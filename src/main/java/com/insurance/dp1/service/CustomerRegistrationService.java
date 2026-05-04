package com.insurance.dp1.service;

import com.insurance.dp1.entity.CustomerRegistration;
import com.insurance.dp1.repository.CustomerRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerRegistrationService {

    private final CustomerRegistrationRepository repository;

    public List<CustomerRegistration> findAll() {
        return repository.findAll();
    }

    public Optional<CustomerRegistration> findById(String id) {
        return repository.findById(id);
    }

    public CustomerRegistration save(CustomerRegistration entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
