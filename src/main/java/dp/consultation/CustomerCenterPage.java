package dp.consultation;

/**
 * CustomerCenterPage(고객센터페이지)
 * 4.3.2 클래스 다이어그램 반영
 */
public class CustomerCenterPage {

    // --- Attributes ---
    private String activeTab;    // [활성 탭]

    // --- Operations ---

    /**
     * 탭 전환
     * 사용자가 FAQ, 1:1문의 등 다른 탭을 클릭했을 때 호출됨
     */
    public void switchTab() {
        System.out.println("탭이 전환되었습니다. 현재 활성 탭: " + activeTab);
    }

    // Getter/Setter (필요 시)
    public String getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
    }
}