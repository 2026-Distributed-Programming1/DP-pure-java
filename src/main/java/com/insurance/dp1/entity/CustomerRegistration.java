package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class CustomerRegistration {

    @Id
    private String customerId;

    private String name;
    private String ssn;
    private Boolean isSsnMasked;
    private String phone;
    private String address;
    private String contractNo;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    private LocalDate contractDate;
    private LocalDate expiryDate;
    private Long monthlyPremium;

    @ElementCollection
    private List<String> specialClauses;
}
