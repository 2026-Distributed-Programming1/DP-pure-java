package dp.dao;

import dp.consultation.InterviewSchedule;
import dp.db.DBA;
import java.util.List;

public class InterviewScheduleDAO {

    public static void save(InterviewSchedule s) {
        DBA.executeUpdate(
            "INSERT INTO interview_schedules (schedule_no, customer_name, scheduled_at,"
            + " location, status)"
            + " VALUES (?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            String.valueOf(s.getInterviewNumber()),
            s.getCustomerName(), s.getScheduledAt(), s.getLocation(), s.getStatus());
    }

    public static List<InterviewSchedule> findAll() {
        return DBA.executeQuery(
            "SELECT schedule_no, customer_name, scheduled_at, location, status"
            + " FROM interview_schedules",
            rs -> {
                InterviewSchedule s = new InterviewSchedule();
                java.sql.Timestamp ts = rs.getTimestamp("scheduled_at");
                java.time.LocalDateTime scheduledAt = ts != null ? ts.toLocalDateTime() : null;
                s.register(rs.getString("customer_name"), scheduledAt,
                    rs.getString("location"), null);
                s.setStatus(rs.getString("status"));
                return s;
            });
    }
}