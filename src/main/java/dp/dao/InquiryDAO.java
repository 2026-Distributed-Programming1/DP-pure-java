package dp.dao;

import dp.db.DBA;
import dp.inquiry.Inquiry;

public class InquiryDAO {

    public static void save(Inquiry i) {
        String inquiryType = i.getInquiryType() != null ? i.getInquiryType().name() : null;
        String status = i.getStatus() != null ? i.getStatus().name() : null;
        DBA.executeUpdate(
            "INSERT INTO inquiries (inquiry_no, customer_name, inquiry_type, content,"
            + " status, created_at)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            i.getInquiryNo(),
            null,
            inquiryType,
            i.getContent(),
            status,
            i.getReceivedAt());
    }
}