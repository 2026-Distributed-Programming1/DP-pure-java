package dp.dao;

import dp.db.DBA;
import dp.enums.InsuranceType;
import dp.sales.CustomerRegistration;
import java.util.List;

public class CustomerRegistrationDAO {

    public static void save(CustomerRegistration r) {
        String insuranceType = r.getInsuranceType() != null ? r.getInsuranceType().name() : null;
        DBA.executeUpdate(
            "INSERT INTO customer_registrations (customer_id, name, ssn_masked, phone,"
            + " insurance_type, contract_date, expiry_date, monthly_premium)"
            + " VALUES (?,?,?,?,?,?,?,?)",
            r.getCustomerId(),
            r.getName(),
            r.getMaskedSsn(),
            r.getPhone(),
            insuranceType,
            r.getContractDate(),
            r.getExpiryDate(),
            r.getMonthlyPremium());
    }

    public static List<CustomerRegistration> findAll() {
        return DBA.executeQuery(
            "SELECT customer_id, name, ssn_masked, phone, insurance_type,"
            + " contract_date, expiry_date, monthly_premium FROM customer_registrations",
            rs -> {
                CustomerRegistration r = new CustomerRegistration();
                r.setName(rs.getString("name"));
                r.setSsn(rs.getString("ssn_masked"));
                r.setPhone(rs.getString("phone"));
                String it = rs.getString("insurance_type");
                if (it != null) {
                    try { r.setInsuranceType(InsuranceType.valueOf(it)); }
                    catch (IllegalArgumentException ignored) {}
                }
                java.sql.Date cd = rs.getDate("contract_date");
                if (cd != null) r.setContractDate(cd.toLocalDate());
                java.sql.Date ed = rs.getDate("expiry_date");
                if (ed != null) r.setExpiryDate(ed.toLocalDate());
                r.setMonthlyPremium(rs.getLong("monthly_premium"));
                return r;
            });
    }
}