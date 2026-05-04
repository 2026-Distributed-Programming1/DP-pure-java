package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Contract {

    @Id
    private String contractNo;

    private String insuranceType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long monthlyPremium;

    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    private Boolean isExpiringSoon;
    private Integer totalPayCount;
    private Integer paidCount;
    private LocalDate lastPaymentDate;
    private Boolean isOverdue;
    private Integer overdueCount;

    @ElementCollection
    private List<String> specialClauses;

    @ElementCollection
    private List<Long> clausePremiums;
}
