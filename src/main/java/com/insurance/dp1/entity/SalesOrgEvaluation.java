package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ChannelType;
import com.insurance.dp1.entity.enums.EvaluationGrade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class SalesOrgEvaluation {

    @Id
    private String evaluationNo;

    private LocalDate filterStartDate;
    private LocalDate filterEndDate;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    private String channelName;
    private Long salesResult;
    private Integer contractCount;
    private Double achievementRate;

    @Enumerated(EnumType.STRING)
    private EvaluationGrade evaluationGrade;

    private String evaluationComment;
    private LocalDateTime evaluatedAt;
}
