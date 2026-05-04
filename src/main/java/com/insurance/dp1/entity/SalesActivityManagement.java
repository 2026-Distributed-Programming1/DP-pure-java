package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ChannelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class SalesActivityManagement {

    @Id
    private String managementNo;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    private String channelName;
    private Integer visitCount;
    private Integer contractCount;
    private Double conversionRate;
    private Double achievementRate;
    private String improvementContent;
    private Integer revisedTarget;
    private LocalDateTime registeredAt;
}
