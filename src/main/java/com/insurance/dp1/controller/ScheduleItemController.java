package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ScheduleItem;
import com.insurance.dp1.service.ScheduleItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule-items")
@RequiredArgsConstructor
public class ScheduleItemController {

    private final ScheduleItemService service;

    @GetMapping
    public List<ScheduleItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleItem> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ScheduleItem create(@RequestBody ScheduleItem entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ScheduleItem update(@PathVariable Long id, @RequestBody ScheduleItem entity) {
        entity.setId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
