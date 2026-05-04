package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ChannelType;
import com.insurance.dp1.entity.enums.ScreeningStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class ChannelScreening {

    @Id
    private String approvalNo;

    private String applicantName;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;

    private LocalDate applicationDate;
    private String career;

    @ElementCollection
    private List<String> certifications;

    @Enumerated(EnumType.STRING)
    private ScreeningStatus screeningStatus;

    private LocalDateTime approvedAt;
    private String rejectionReason;
    private LocalDate filterStartDate;
    private LocalDate filterEndDate;
}
