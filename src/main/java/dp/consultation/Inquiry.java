package dp.consultation;

import java.time.LocalDateTime;

/**
 * Inquiry(문의)
 * 4.3.1 클래스 다이어그램 반영
 */
public class Inquiry {

    // --- Attributes ---
    private String inquiryNo;            // 문의 번호 - 자동부여
    private String inquiryType;          // 문의 유형 (enum 대신 String 우선 사용 가능)
    private String title;                // 제목
    private String content;              // 내용
    private Integer currentLength;       // 현재 입력 글자 수
    private String attachmentFileName;   // 첨부 파일명
    private Long attachmentFileSize;     // 첨부 파일 크기
    private LocalDateTime receivedAt;    // 접수 일시
    private String status;               // 처리 상태
    private String answerContent;        // 담당자 답변 내용
    private LocalDateTime answeredAt;    // 답변 일시
    private String faqCategory;          // FAQ 카테고리
    private String faqQuestion;          // FAQ 질문
    private String faqAnswer;            // FAQ 답변

    // --- Operations ---

    /** 필수 항목 검증 */
    public Boolean validateRequired() {
        return title != null && !title.isEmpty() && content != null && !content.isEmpty();
    }

    /** 오류 필드 강조 */
    public void highlighterError() {
        System.out.println("입력 오류가 발생한 필드를 강조합니다.");
    }

    /** 첨부 파일 용량 검증 - 10MB 이하 */
    public Boolean validateFileSize() {
        if (attachmentFileSize == null) return true;
        return attachmentFileSize <= 10 * 1024 * 1024; // 10MB
    }

    /** 파일 첨부 */
    public void attachFile() {
        System.out.println("파일이 첨부되었습니다.");
    }

    /** 첨부 파일 삭제 */
    public void removeFile() {
        this.attachmentFileName = null;
        this.attachmentFileSize = 0L;
    }

    /** 문의 제출 */
    public void submit() {
        this.receivedAt = LocalDateTime.now();
        this.status = "답변대기";
        System.out.println("문의가 제출되었습니다.");
    }

    /** 접수 완료 팝업 출력 */
    public void showSuccessPopup() {
        System.out.println("문의 접수가 완료되었습니다.");
    }

    /** 접수 확인 문자 발송 */
    public void sendConfirmSms() {
        System.out.println("접수 확인 문자를 발송했습니다.");
    }

    /** 문의 상세 조회 */
    public void getDetail() {
        System.out.println("문의 상세 내용을 조회합니다.");
    }

    /** FAQ 카테고리 필터링 */
    public void filterFaqByCategory() {
        System.out.println("선택한 카테고리로 FAQ를 필터링합니다.");
    }

    /** FAQ 아코디언 펼치기 */
    public void toggleFaqItem() {
        System.out.println("FAQ 상세 내용을 펼치거나 접습니다.");
    }

    /** 문의 내역 목록 조회 */
    public void getHistoryList() {
        System.out.println("이전 문의 내역 목록을 조회합니다.");
    }

    /** 파일 용량 초과 오류 메시지 */
    public void showFileSizeError() {
        System.out.println("파일 용량이 10MB를 초과하였습니다.");
    }
}