package com.insurance.dp1.service;

import com.insurance.dp1.entity.ActivityPlan;
import com.insurance.dp1.repository.ActivityPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityPlanService {

    private final ActivityPlanRepository repository;

    public List<ActivityPlan> findAll() {
        return repository.findAll();
    }

    public Optional<ActivityPlan> findById(String id) {
        return repository.findById(id);
    }

    public ActivityPlan save(ActivityPlan entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
