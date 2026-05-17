package dp.dao;

import dp.consultation.Proposal;
import dp.db.DBA;

public class ProposalDAO {

    public static void save(Proposal p) {
        String productName = p.getInsuranceProduct() != null
                ? p.getInsuranceProduct().getProductName() : null;
        long premium = p.getInsuranceProduct() != null
                ? p.getInsuranceProduct().getMonthlyPremium() : 0L;
        DBA.executeUpdate(
            "INSERT INTO proposals (proposal_no, customer_name, product_name, monthly_premium, created_at)"
            + " VALUES (?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE product_name=VALUES(product_name)",
            String.valueOf(p.getProposalId()),
            p.getCustomerName(),
            productName,
            premium,
            p.getSentAt());
    }
}