package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.BonusGrade;
import com.insurance.dp1.entity.enums.ChannelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BonusRequest {

    @Id
    private String evaluationNo;

    private String channelName;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    @Enumerated(EnumType.STRING)
    private BonusGrade evaluationGrade;

    private Double bonusRatio;
    private Long baseSalary;
    private Long bonusAmount;
    private String requestReason;
    private String requestNo;
    private LocalDateTime requestedAt;
}
