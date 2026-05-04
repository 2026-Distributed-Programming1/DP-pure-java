package com.insurance.dp1.service;

import com.insurance.dp1.entity.Inquiry;
import com.insurance.dp1.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository repository;

    public List<Inquiry> findAll() {
        return repository.findAll();
    }

    public Optional<Inquiry> findById(String id) {
        return repository.findById(id);
    }

    public Inquiry save(Inquiry entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
