package dp.dao;

import dp.db.DBA;
import dp.payment.Payment;

public class PaymentDAO {

    public static void save(Payment p) {
        String customerId   = p.getCustomer() != null ? p.getCustomer().getCustomerId() : null;
        String customerName = p.getCustomer() != null ? p.getCustomer().getName() : null;
        String method       = p.getPaymentMethod() != null ? p.getPaymentMethod().name() : null;
        String status       = p.getStatus() != null ? p.getStatus().name() : null;
        DBA.executeUpdate(
            "INSERT INTO payments (payment_no, customer_id, customer_name, total_amount,"
            + " payment_method, requested_at, status)"
            + " VALUES (?,?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE status=VALUES(status)",
            p.getPaymentNo(), customerId, customerName,
            p.getDiscountedAmount(), method, p.getRequestedAt(), status);
    }
}