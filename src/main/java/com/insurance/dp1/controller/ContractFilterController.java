package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ContractFilter;
import com.insurance.dp1.service.ContractFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract-filters")
@RequiredArgsConstructor
public class ContractFilterController {

    private final ContractFilterService service;

    @GetMapping
    public List<ContractFilter> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractFilter> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractFilter create(@RequestBody ContractFilter entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ContractFilter update(@PathVariable Long id, @RequestBody ContractFilter entity) {
        entity.setId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
