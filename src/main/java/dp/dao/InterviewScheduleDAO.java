package dp.dao;

import dp.consultation.InterviewSchedule;
import dp.db.DBA;
import java.util.ArrayList;
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
                String scheduleNo = rs.getString("schedule_no");
                int interviewNumber = 0;
                if (scheduleNo != null) {
                    try { interviewNumber = Integer.parseInt(scheduleNo); }
                    catch (NumberFormatException ignored) {}
                }
                java.sql.Timestamp ts = rs.getTimestamp("scheduled_at");
                java.time.LocalDateTime scheduledAt = ts != null ? ts.toLocalDateTime() : null;
                return InterviewSchedule.fromDb(
                        interviewNumber,
                        rs.getString("customer_name"),
                        scheduledAt,
                        rs.getString("location"),
                        rs.getString("status"));
            });
    }
}
