package dp.dao;

import dp.claim.AccidentReport;
import dp.db.DBA;

public class AccidentReportDAO {

    public static void save(AccidentReport r) {
        DBA.executeUpdate(
            "INSERT INTO accident_reports (accident_no, customer_id, customer_name,"
            + " accident_type, reported_at, status)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            r.getReportNo(),
            r.getCustomer() != null ? r.getCustomer().getCustomerId() : null,
            r.getCustomer() != null ? r.getCustomer().getName() : null,
            r.getAccidentType() != null ? r.getAccidentType().name() : null,
            r.getReportedAt(),
            r.getStatus() != null ? r.getStatus().name() : null);
    }
}