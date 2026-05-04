package com.insurance.dp1.service;

import com.insurance.dp1.entity.ContractStatistics;
import com.insurance.dp1.repository.ContractStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractStatisticsService {

    private final ContractStatisticsRepository repository;

    public List<ContractStatistics> findAll() {
        return repository.findAll();
    }

    public Optional<ContractStatistics> findById(Long id) {
        return repository.findById(id);
    }

    public ContractStatistics save(ContractStatistics entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
