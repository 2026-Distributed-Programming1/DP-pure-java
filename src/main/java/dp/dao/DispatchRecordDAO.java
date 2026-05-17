package dp.dao;

import dp.claim.DispatchRecord;
import dp.db.DBA;

public class DispatchRecordDAO {

    public static void save(DispatchRecord r) {
        DBA.executeUpdate(
            "INSERT INTO dispatch_records (record_no, dispatch_no, agent_name, status)"
            + " VALUES (?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            r.getRecordId(),
            r.getDispatch() != null ? r.getDispatch().getDispatchNo() : null,
            r.getDispatch() != null && r.getDispatch().getAgent() != null
                ? r.getDispatch().getAgent().getName() : null,
            r.getStatus() != null ? r.getStatus().name() : null);
    }
}