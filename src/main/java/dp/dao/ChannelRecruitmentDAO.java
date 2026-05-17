package dp.dao;

import dp.db.DBA;
import dp.enums.ChannelType;
import dp.sales.ChannelRecruitment;
import java.util.List;

public class ChannelRecruitmentDAO {

    public static void save(ChannelRecruitment r) {
        String channelType = r.getChannelType() != null ? r.getChannelType().name() : null;
        DBA.executeUpdate(
            "INSERT INTO channel_recruitments (recruitment_no, manager_name, candidate_name,"
            + " channel_type, status, created_at)"
            + " VALUES (?,?,?,?,?,?)"
            + " ON DUPLICATE KEY UPDATE channel_type=VALUES(channel_type)",
            r.getRecruitmentNo(),
            null,
            null,
            channelType,
            null,
            r.getRegisteredAt());
    }

    public static List<ChannelRecruitment> findAll() {
        return DBA.executeQuery(
            "SELECT recruitment_no, channel_type, created_at FROM channel_recruitments",
            rs -> {
                ChannelRecruitment r = new ChannelRecruitment();
                String ct = rs.getString("channel_type");
                if (ct != null) {
                    try { r.setChannelType(ChannelType.valueOf(ct)); }
                    catch (IllegalArgumentException ignored) {}
                }
                return r;
            });
    }
}