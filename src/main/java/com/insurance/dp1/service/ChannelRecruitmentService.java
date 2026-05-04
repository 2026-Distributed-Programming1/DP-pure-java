package com.insurance.dp1.service;

import com.insurance.dp1.entity.ChannelRecruitment;
import com.insurance.dp1.repository.ChannelRecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelRecruitmentService {

    private final ChannelRecruitmentRepository repository;

    public List<ChannelRecruitment> findAll() {
        return repository.findAll();
    }

    public Optional<ChannelRecruitment> findById(String id) {
        return repository.findById(id);
    }

    public ChannelRecruitment save(ChannelRecruitment entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
