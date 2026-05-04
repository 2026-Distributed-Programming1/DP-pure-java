package com.insurance.dp1.controller;

import com.insurance.dp1.entity.SalesOrgEvaluation;
import com.insurance.dp1.service.SalesOrgEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-org-evaluations")
@RequiredArgsConstructor
public class SalesOrgEvaluationController {

    private final SalesOrgEvaluationService service;

    @GetMapping
    public List<SalesOrgEvaluation> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrgEvaluation> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesOrgEvaluation create(@RequestBody SalesOrgEvaluation entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public SalesOrgEvaluation update(@PathVariable String id, @RequestBody SalesOrgEvaluation entity) {
        entity.setEvaluationNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
