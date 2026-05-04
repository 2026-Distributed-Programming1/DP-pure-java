package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.ChannelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Applicant {

    @Id
    private String applicantId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ChannelType channelType;
}
