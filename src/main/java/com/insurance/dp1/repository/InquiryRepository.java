package com.insurance.dp1.repository;

import com.insurance.dp1.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, String> {
}
