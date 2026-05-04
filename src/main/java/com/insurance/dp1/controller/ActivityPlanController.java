package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ActivityPlan;
import com.insurance.dp1.service.ActivityPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-plans")
@RequiredArgsConstructor
public class ActivityPlanController {

    private final ActivityPlanService service;

    @GetMapping
    public List<ActivityPlan> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityPlan> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ActivityPlan create(@RequestBody ActivityPlan entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ActivityPlan update(@PathVariable String id, @RequestBody ActivityPlan entity) {
        entity.setPlanId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
