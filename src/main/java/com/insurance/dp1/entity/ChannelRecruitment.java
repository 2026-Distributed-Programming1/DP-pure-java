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
public class ChannelRecruitment {

    @Id
    private String recruitmentNo;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    private Integer recruitCount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String condition;
    private LocalDateTime registeredAt;
}
