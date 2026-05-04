package com.insurance.dp1.controller;

import com.insurance.dp1.entity.SalesManager;
import com.insurance.dp1.service.SalesManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-managers")
@RequiredArgsConstructor
public class SalesManagerController {

    private final SalesManagerService service;

    @GetMapping
    public List<SalesManager> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesManager> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesManager create(@RequestBody SalesManager entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public SalesManager update(@PathVariable String id, @RequestBody SalesManager entity) {
        entity.setManagerId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
