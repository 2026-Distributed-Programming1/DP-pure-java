package dp.dao;

import dp.db.DBA;
import dp.education.EducationPreparation;
import java.util.List;

public class EducationPreparationDAO {

    public static void save(EducationPreparation e) {
        DBA.executeUpdate(
            "INSERT INTO education_preparations (prep_no, plan_no, trainer_name, venue,"
            + " material_ready, status)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE venue=VALUES(venue), status=VALUES(status)",
            String.valueOf(e.getSetupNumber()),
            null,
            e.getInstructorName(),
            e.getLocation(),
            false,
            null);
    }

    public static List<EducationPreparation> findAll() {
        return DBA.executeQuery(
            "SELECT prep_no, trainer_name, venue, status FROM education_preparations",
            rs -> {
                EducationPreparation e = new EducationPreparation();
                e.enterPreparationInfo(
                    rs.getString("venue"),
                    rs.getString("trainer_name"),
                    null);
                return e;
            });
    }
}