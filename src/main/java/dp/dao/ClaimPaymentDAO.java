package dp.dao;

import dp.claim.ClaimCalculation;
import dp.claim.ClaimPayment;
import dp.db.DBA;
import dp.enums.ClaimPaymentStatus;
import java.util.List;

public class ClaimPaymentDAO {

    public static void save(ClaimPayment p) {
        String calcNo = p.getCalculation() != null ? p.getCalculation().getCalculationNo() : null;
        String status = p.getStatus() != null ? p.getStatus().name() : null;
        DBA.executeUpdate(
            "INSERT INTO claim_payments (payment_no, calculation_no, final_amount, status)"
            + " VALUES (?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            p.getPaymentNo(), calcNo, p.getFinalAmount(), status);
    }

    public static List<ClaimPayment> findAll() {
        return DBA.executeQuery(
            "SELECT payment_no, calculation_no, final_amount, status FROM claim_payments",
            rs -> {
                String cno = rs.getString("calculation_no");
                ClaimCalculation calcShell = new ClaimCalculation(
                    cno != null ? cno : "?", null, 0, 0, 0,
                    false, false, null);
                String st = rs.getString("status");
                ClaimPaymentStatus status = ClaimPaymentStatus.WAITING;
                if (st != null) {
                    try { status = ClaimPaymentStatus.valueOf(st); }
                    catch (IllegalArgumentException ignored) {}
                }
                return new ClaimPayment(
                    rs.getString("payment_no"), calcShell,
                    rs.getLong("final_amount"), status);
            });
    }
}