package com.insurance.dp1.service;

import com.insurance.dp1.entity.SalesActivityManagement;
import com.insurance.dp1.repository.SalesActivityManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesActivityManagementService {

    private final SalesActivityManagementRepository repository;

    public List<SalesActivityManagement> findAll() {
        return repository.findAll();
    }

    public Optional<SalesActivityManagement> findById(String id) {
        return repository.findById(id);
    }

    public SalesActivityManagement save(SalesActivityManagement entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
