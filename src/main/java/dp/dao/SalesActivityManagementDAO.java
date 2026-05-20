package dp.dao;

import dp.db.DBA;
import dp.sales.SalesActivityManagement;
import java.util.List;

public class SalesActivityManagementDAO {

    public static void save(SalesActivityManagement a) {
        DBA.executeUpdate(
            "INSERT INTO sales_activity_managements (activity_no, manager_name, channel_name,"
            + " activity_type, created_at)"
            + " VALUES (?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE channel_name=VALUES(channel_name)",
            a.getManagementNo(),
            a.getManagerName(),
            a.getChannelName(),
            null,
            a.getRegisteredAt());
    }

    public static List<SalesActivityManagement> findAll() {
        return DBA.executeQuery(
            "SELECT activity_no, channel_name, created_at FROM sales_activity_managements",
            rs -> {
                SalesActivityManagement a = new SalesActivityManagement();
                a.setChannelName(rs.getString("channel_name"));
                return a;
            });
    }
}