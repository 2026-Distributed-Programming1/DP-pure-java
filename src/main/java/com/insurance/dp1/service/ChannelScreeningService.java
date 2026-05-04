package com.insurance.dp1.service;

import com.insurance.dp1.entity.ChannelScreening;
import com.insurance.dp1.repository.ChannelScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelScreeningService {

    private final ChannelScreeningRepository repository;

    public List<ChannelScreening> findAll() {
        return repository.findAll();
    }

    public Optional<ChannelScreening> findById(String id) {
        return repository.findById(id);
    }

    public ChannelScreening save(ChannelScreening entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
