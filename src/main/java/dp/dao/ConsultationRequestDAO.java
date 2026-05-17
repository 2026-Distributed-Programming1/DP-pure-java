package dp.dao;

import dp.consultation.ConsultationRequest;
import dp.db.DBA;

public class ConsultationRequestDAO {

    public static void save(ConsultationRequest r) {
        DBA.executeUpdate(
            "INSERT INTO consultation_requests (consult_no, channel, requested_at)"
            + " VALUES (?,?,?)"
            + " ON DUPLICATE KEY UPDATE channel=VALUES(channel)",
            String.valueOf(r.getConsultationNumber()),
            r.getType(),
            r.getScheduledAt());
    }
}