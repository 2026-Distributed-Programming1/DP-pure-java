package com.insurance.dp1.service;

import com.insurance.dp1.entity.CustomerCenterPage;
import com.insurance.dp1.repository.CustomerCenterPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerCenterPageService {

    private final CustomerCenterPageRepository repository;

    public List<CustomerCenterPage> findAll() {
        return repository.findAll();
    }

    public Optional<CustomerCenterPage> findById(Long id) {
        return repository.findById(id);
    }

    public CustomerCenterPage save(CustomerCenterPage entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
