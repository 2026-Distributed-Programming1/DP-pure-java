package com.insurance.dp1.service;

import com.insurance.dp1.entity.SalesManager;
import com.insurance.dp1.repository.SalesManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesManagerService {

    private final SalesManagerRepository repository;

    public List<SalesManager> findAll() {
        return repository.findAll();
    }

    public Optional<SalesManager> findById(String id) {
        return repository.findById(id);
    }

    public SalesManager save(SalesManager entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
