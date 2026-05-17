package dp.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Database Access (DBA)
 *
 * JDBC 연결을 관리하고 SQL 실행을 담당하는 클래스이다.
 * DAO -> DBA -> DB 계층에서 중간 계층 역할을 한다.
 *
 * 사용법:
 *   DBA.executeUpdate("INSERT INTO customers VALUES (?,?,?)", id, name, phone);
 *   List<Customer> list = DBA.executeQuery("SELECT * FROM customers", rs -> {
 *       Customer c = new Customer(...);
 *       return c;
 *   });
 */
public class DBA {

    private static final String URL  = "jdbc:mysql://localhost:3306/insurance_db"
            + "?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true"
            + "&characterEncoding=UTF-8";
    private static final String USER = "admin";
    private static final String PASS = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    private DBA() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /** ResultSet → 객체 매핑 함수형 인터페이스 */
    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    /**
     * INSERT / UPDATE / DELETE 실행
     * @return 영향받은 행 수
     */
    public static int executeUpdate(String sql, Object... params) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            setParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DBA] executeUpdate 오류: " + e.getMessage());
            return 0;
        }
    }

    /**
     * SELECT 실행
     * @param mapper  ResultSet 한 행을 객체로 변환하는 함수
     * @return 결과 목록
     */
    public static <T> List<T> executeQuery(String sql, ResultSetMapper<T> mapper, Object... params) {
        List<T> result = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            setParams(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    T row = mapper.map(rs);
                    if (row != null) result.add(row);
                }
            }
        } catch (SQLException e) {
            System.err.println("[DBA] executeQuery 오류: " + e.getMessage());
        }
        return result;
    }

    /**
     * 단일 행 SELECT (없으면 null)
     */
    public static <T> T queryOne(String sql, ResultSetMapper<T> mapper, Object... params) {
        List<T> list = executeQuery(sql, mapper, params);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 존재 여부 확인
     */
    public static boolean exists(String sql, Object... params) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            setParams(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("[DBA] exists 오류: " + e.getMessage());
            return false;
        }
    }

    private static void setParams(PreparedStatement ps, Object[] params) throws SQLException {
        if (params == null) return;
        for (int i = 0; i < params.length; i++) {
            Object p = params[i];
            if (p == null)                          ps.setNull(i + 1, Types.NULL);
            else if (p instanceof String s)         ps.setString(i + 1, s);
            else if (p instanceof Integer n)        ps.setInt(i + 1, n);
            else if (p instanceof Long n)           ps.setLong(i + 1, n);
            else if (p instanceof Double d)         ps.setDouble(i + 1, d);
            else if (p instanceof Boolean b)        ps.setBoolean(i + 1, b);
            else if (p instanceof java.time.LocalDate d)
                ps.setDate(i + 1, java.sql.Date.valueOf(d));
            else if (p instanceof java.time.LocalDateTime dt)
                ps.setTimestamp(i + 1, java.sql.Timestamp.valueOf(dt));
            else                                    ps.setObject(i + 1, p);
        }
    }
}
