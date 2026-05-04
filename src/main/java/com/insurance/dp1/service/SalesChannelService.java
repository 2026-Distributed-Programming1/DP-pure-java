package com.insurance.dp1.service;

import com.insurance.dp1.entity.SalesChannel;
import com.insurance.dp1.repository.SalesChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesChannelService {

    private final SalesChannelRepository repository;

    public List<SalesChannel> findAll() {
        return repository.findAll();
    }

    public Optional<SalesChannel> findById(String id) {
        return repository.findById(id);
    }

    public SalesChannel save(SalesChannel entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
