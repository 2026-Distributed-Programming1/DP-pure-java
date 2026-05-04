package com.insurance.dp1.service;

import com.insurance.dp1.entity.ContractManager;
import com.insurance.dp1.repository.ContractManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractManagerService {

    private final ContractManagerRepository repository;

    public List<ContractManager> findAll() {
        return repository.findAll();
    }

    public Optional<ContractManager> findById(String id) {
        return repository.findById(id);
    }

    public ContractManager save(ContractManager entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
