package com.insurance.dp1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private String customerId;

    private String name;
    private String phone;
}
