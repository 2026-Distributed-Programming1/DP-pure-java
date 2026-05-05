package dp.sales;

import dp.enums.ChannelType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 판매채널 모집 (ChannelRecruitment)
 * 영업 관리자가 새로운 판매채널을 모집하기 위해 공고를 등록하고 관리하는 클래스이다.
 */
public class ChannelRecruitment {
    private String recruitmentNo;
    private ChannelType channelType; // enum
    private Integer recruitCount;
    private Date startDate;
    private Date endDate;
    private String condition;
    private Date registeredAt; // DateTime

    private LocalDate localStartDate;
    private LocalDate localEndDate;
    private LocalDateTime localRegisteredAt;

    public void loadRecruitmentList() {}
    public void openRegistrationForm() {}
    public Boolean validateRequired() {
        return channelType != null && recruitCount != null && recruitCount > 0
                && localStartDate != null && localEndDate != null;
    }
    public void highlighterError() {}
    public void save() {
        this.localRegisteredAt = LocalDateTime.now();
        this.recruitmentNo = "RC-" + localRegisteredAt.toString().replaceAll("[^0-9]", "").substring(0, 14);
    }
    public void showSaveSuccess() {}
    public void showSaveResult() {}
    public void cancel() {}
    public void showCancelConfirm() {}
    public void close() {}
    public void returnToActivityManagement() {}
    public void openCalendar() {}
    public void showRequiredError() {}

    // Getters / Setters
    public String getRecruitmentNo() { return recruitmentNo; }
    public ChannelType getChannelType() { return channelType; }
    public void setChannelType(ChannelType channelType) { this.channelType = channelType; }
    public Integer getRecruitCount() { return recruitCount; }
    public void setRecruitCount(Integer recruitCount) { this.recruitCount = recruitCount; }
    public LocalDate getLocalStartDate() { return localStartDate; }
    public void setLocalStartDate(LocalDate localStartDate) { this.localStartDate = localStartDate; }
    public LocalDate getLocalEndDate() { return localEndDate; }
    public void setLocalEndDate(LocalDate localEndDate) { this.localEndDate = localEndDate; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public LocalDateTime getLocalRegisteredAt() { return localRegisteredAt; }
}