package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ClaimStatus;
import com.insurance.dp1.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class ContractStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNo;
    private String contractorName;
    private Integer paySequence;
    private LocalDate paymentDate;
    private Long paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime claimDate;
    private Long claimAmount;
    private Long paidAmount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    @ElementCollection
    private List<String> monthlyRetentionData;

    private String filterStartMonth;
    private String filterEndMonth;
    private String fileName;
}
