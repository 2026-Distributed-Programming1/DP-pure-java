package com.insurance.dp1.service;

import com.insurance.dp1.entity.SalesOrgEvaluation;
import com.insurance.dp1.repository.SalesOrgEvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesOrgEvaluationService {

    private final SalesOrgEvaluationRepository repository;

    public List<SalesOrgEvaluation> findAll() {
        return repository.findAll();
    }

    public Optional<SalesOrgEvaluation> findById(String id) {
        return repository.findById(id);
    }

    public SalesOrgEvaluation save(SalesOrgEvaluation entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
