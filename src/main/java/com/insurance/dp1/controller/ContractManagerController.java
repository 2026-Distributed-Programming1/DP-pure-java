package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ContractManager;
import com.insurance.dp1.service.ContractManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract-managers")
@RequiredArgsConstructor
public class ContractManagerController {

    private final ContractManagerService service;

    @GetMapping
    public List<ContractManager> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractManager> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractManager create(@RequestBody ContractManager entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ContractManager update(@PathVariable String id, @RequestBody ContractManager entity) {
        entity.setManagerId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
