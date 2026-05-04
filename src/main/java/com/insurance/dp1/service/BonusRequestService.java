package com.insurance.dp1.service;

import com.insurance.dp1.entity.BonusRequest;
import com.insurance.dp1.repository.BonusRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BonusRequestService {

    private final BonusRequestRepository repository;

    public List<BonusRequest> findAll() {
        return repository.findAll();
    }

    public Optional<BonusRequest> findById(String id) {
        return repository.findById(id);
    }

    public BonusRequest save(BonusRequest entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
