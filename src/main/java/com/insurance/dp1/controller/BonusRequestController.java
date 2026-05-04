package com.insurance.dp1.controller;

import com.insurance.dp1.entity.BonusRequest;
import com.insurance.dp1.service.BonusRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonus-requests")
@RequiredArgsConstructor
public class BonusRequestController {

    private final BonusRequestService service;

    @GetMapping
    public List<BonusRequest> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonusRequest> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BonusRequest create(@RequestBody BonusRequest entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public BonusRequest update(@PathVariable String id, @RequestBody BonusRequest entity) {
        entity.setEvaluationNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
