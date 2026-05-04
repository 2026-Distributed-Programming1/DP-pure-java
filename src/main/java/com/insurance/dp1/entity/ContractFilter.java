package com.insurance.dp1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ContractFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String name;
    private String ssn;
    private String phone;
    private String contractNo;
    private String insuranceType;
    private LocalDate contractDate;
}
