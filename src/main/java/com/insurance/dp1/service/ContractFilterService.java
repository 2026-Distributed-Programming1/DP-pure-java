package com.insurance.dp1.service;

import com.insurance.dp1.entity.ContractFilter;
import com.insurance.dp1.repository.ContractFilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractFilterService {

    private final ContractFilterRepository repository;

    public List<ContractFilter> findAll() {
        return repository.findAll();
    }

    public Optional<ContractFilter> findById(Long id) {
        return repository.findById(id);
    }

    public ContractFilter save(ContractFilter entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
