package dp.actor;

import dp.education.EducationPlan;

/**
 * 영업 관리자 (SalesManager)
 * 영업 활동 관리, 판매채널 모집/심사/평가, 성과급 요청 유스케이스의 주요 액터이다.
 */
public class SalesManager {

    private String managerId;    // 관리자 ID
    private String name;         // 이름
    private String department;   // 부서
/** 원래 클래스 다이어그램에는 SaleManager 파라미터에 email이 없는데, SampleData와 형식 달라서 email 추가*/
    public SalesManager(String name, String department, String email) {
        this.managerId = "MGR-" + name;
        this.name = name;
        this.department = department;
    }

    // ===== Runner 호출 중이므로 유지 =====
    public void approveEducationPlan(EducationPlan plan) {
        plan.setStatus("승인");
        System.out.println("  [영업관리자] 교육계획안이 승인되었습니다.");
    }

    public void rejectEducationPlan(EducationPlan plan, String reason) {
        plan.reject(reason);
        System.out.println("  [영업관리자] 교육계획안이 반려되었습니다. 사유: " + reason);
    }

    public String getName() { return name; }
}