package dp.dao;

import dp.db.DBA;
import dp.education.EducationPlan;
import java.util.List;

public class EducationPlanDAO {

    public static void save(EducationPlan p) {
        DBA.executeUpdate(
            "INSERT INTO education_plans (plan_no, trainer_name, title, target_audience,"
            + " scheduled_date, status)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            String.valueOf(p.getPlanNumber()),
            null,
            p.getEducationName(),
            p.getChannelType(),
            p.getStartDate(),
            p.getStatus());
    }

    public static List<EducationPlan> findAll() {
        return DBA.executeQuery(
            "SELECT plan_no, title, target_audience, scheduled_date, status FROM education_plans",
            rs -> {
                EducationPlan p = new EducationPlan();
                java.sql.Date sd = rs.getDate("scheduled_date");
                java.time.LocalDate startDate = sd != null ? sd.toLocalDate() : null;
                p.enterPlanInfo(
                    rs.getString("title"),
                    startDate, startDate,
                    rs.getString("target_audience"),
                    0, 0L);
                p.setStatus(rs.getString("status"));
                return p;
            });
    }
}