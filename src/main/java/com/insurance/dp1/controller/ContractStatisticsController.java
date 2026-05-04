package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ContractStatistics;
import com.insurance.dp1.service.ContractStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract-statistics")
@RequiredArgsConstructor
public class ContractStatisticsController {

    private final ContractStatisticsService service;

    @GetMapping
    public List<ContractStatistics> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractStatistics> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractStatistics create(@RequestBody ContractStatistics entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ContractStatistics update(@PathVariable Long id, @RequestBody ContractStatistics entity) {
        entity.setId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
