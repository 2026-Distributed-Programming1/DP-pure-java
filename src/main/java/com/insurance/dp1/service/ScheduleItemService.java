package com.insurance.dp1.service;

import com.insurance.dp1.entity.ScheduleItem;
import com.insurance.dp1.repository.ScheduleItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleItemService {

    private final ScheduleItemRepository repository;

    public List<ScheduleItem> findAll() {
        return repository.findAll();
    }

    public Optional<ScheduleItem> findById(Long id) {
        return repository.findById(id);
    }

    public ScheduleItem save(ScheduleItem entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
