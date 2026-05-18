package dp.dao;

import dp.db.DBA;
import dp.sales.ChannelScreening;

public class ChannelScreeningDAO {

    public static void save(ChannelScreening s) {
        String screeningNo = s.getApprovalNo() != null ? s.getApprovalNo()
                : "CS-" + (s.getApplicantName() != null ? s.getApplicantName() : "")
                  + "-" + s.getApplicationDate();
        String channelType = s.getChannelType() != null ? s.getChannelType().name() : null;
        String status = s.getScreeningStatus() != null ? s.getScreeningStatus().name() : null;
        DBA.executeUpdate(
            "INSERT INTO channel_screenings (screening_no, candidate_name, channel_type,"
            + " qualification, status, reviewed_at)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            screeningNo,
            s.getApplicantName(),
            channelType,
            s.getCareer(),
            status,
            s.getApprovedAt());
    }
}