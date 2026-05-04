package dp.sales;

import java.util.Date;

/**
 * 성과급 지급 요청 (BonusRequest)
 * 평가 등급에 따라 성과급 지급을 요청하는 클래스이다.
 */
public class BonusRequest {
    private int requestId;
    private int evaluationNo;
    private long bonusAmount;
    private Date requestDate;
    private String status;

    public void createRequest() {}
    public void approveRequest() {}
}