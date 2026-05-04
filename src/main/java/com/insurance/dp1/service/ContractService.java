package com.insurance.dp1.service;

import com.insurance.dp1.entity.Contract;
import com.insurance.dp1.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository repository;

    public List<Contract> findAll() {
        return repository.findAll();
    }

    public Optional<Contract> findById(String id) {
        return repository.findById(id);
    }

    public Contract save(Contract entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
