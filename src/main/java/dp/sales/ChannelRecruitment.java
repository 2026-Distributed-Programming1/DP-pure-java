package dp.sales;

import java.util.Date;

/**
 * 판매채널 모집 (ChannelRecruitment)
 * 영업 관리자가 새로운 판매채널을 모집하기 위해 공고를 등록하고 관리하는 클래스이다.
 */
public class ChannelRecruitment {
    private int recruitmentNo;
    private String channelType;
    private int recruitCount;
    private Date startDate;
    private Date endDate;
    private String condition;

    public void save() {}
    public boolean validateRequired() { return true; }
}