package com.insurance.dp1.repository;

import com.insurance.dp1.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, String> {
}
