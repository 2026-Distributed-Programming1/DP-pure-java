package com.insurance.dp1.service;

import com.insurance.dp1.entity.Applicant;
import com.insurance.dp1.repository.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantRepository repository;

    public List<Applicant> findAll() {
        return repository.findAll();
    }

    public Optional<Applicant> findById(String id) {
        return repository.findById(id);
    }

    public Applicant save(Applicant entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
