package dp.dao;

import dp.contract.ContractStatistics;
import dp.db.DBA;

public class ContractStatisticsDAO {

    public static void save(ContractStatistics s) {
        DBA.executeUpdate(
            "INSERT INTO contract_statistics (stats_no, total_count, active_count,"
            + " expired_count, cancelled_count)"
            + " VALUES (?,0,0,0,0)"
            + " ON DUPLICATE KEY UPDATE total_count=VALUES(total_count)",
            s.getContractNo() != null ? s.getContractNo() : "STATS-1");
    }
}