package dp.dao;

import dp.db.DBA;
import dp.sales.SalesActivityManagement;

public class SalesActivityManagementDAO {

    public static void save(SalesActivityManagement a) {
        DBA.executeUpdate(
            "INSERT INTO sales_activity_managements (activity_no, manager_name, channel_name,"
            + " activity_type, created_at)"
            + " VALUES (?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE channel_name=VALUES(channel_name)",
            a.getManagementNo(),
            a.getManagerName(),
            a.getChannelName(),
            null,
            a.getRegisteredAt());
    }
}