package com.insurance.dp1.repository;

import com.insurance.dp1.entity.BonusRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRequestRepository extends JpaRepository<BonusRequest, String> {
}
