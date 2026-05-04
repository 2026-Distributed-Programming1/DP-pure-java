package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ActivityPlanStatus;
import com.insurance.dp1.entity.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class ActivityPlan {

    @Id
    private String planId;

    private String planName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String author;
    private String memo;

    @OneToMany(mappedBy = "activityPlan", cascade = CascadeType.ALL)
    private List<ScheduleItem> schedules;

    private Integer targetContractCount;
    private Long targetContractAmount;
    private Integer targetNewCustomer;
    private String proposedCustomerId;

    @Enumerated(EnumType.STRING)
    private InsuranceType proposedInsuranceType;

    private String proposalReason;

    @Enumerated(EnumType.STRING)
    private ActivityPlanStatus status;
}
