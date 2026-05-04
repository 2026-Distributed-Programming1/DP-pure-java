package com.insurance.dp1.controller;

import com.insurance.dp1.entity.SalesActivityManagement;
import com.insurance.dp1.service.SalesActivityManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-activity-managements")
@RequiredArgsConstructor
public class SalesActivityManagementController {

    private final SalesActivityManagementService service;

    @GetMapping
    public List<SalesActivityManagement> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesActivityManagement> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesActivityManagement create(@RequestBody SalesActivityManagement entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public SalesActivityManagement update(@PathVariable String id, @RequestBody SalesActivityManagement entity) {
        entity.setManagementNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
