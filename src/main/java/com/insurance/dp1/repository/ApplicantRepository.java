package com.insurance.dp1.repository;

import com.insurance.dp1.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, String> {
}
