package dp.dao;

import dp.db.DBA;
import dp.sales.SalesOrgEvaluation;

public class SalesOrgEvaluationDAO {

    public static void save(SalesOrgEvaluation e) {
        String grade = e.getEvaluationGrade() != null ? e.getEvaluationGrade().name() : null;
        DBA.executeUpdate(
            "INSERT INTO sales_org_evaluations (evaluation_no, org_name, grade, score, evaluated_at)"
            + " VALUES (?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE grade=VALUES(grade)",
            e.getEvaluationNo(),
            e.getChannelName(),
            grade,
            0.0,
            e.getEvaluatedAt());
    }
}