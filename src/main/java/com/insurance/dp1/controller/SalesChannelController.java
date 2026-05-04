package com.insurance.dp1.controller;

import com.insurance.dp1.entity.SalesChannel;
import com.insurance.dp1.service.SalesChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-channels")
@RequiredArgsConstructor
public class SalesChannelController {

    private final SalesChannelService service;

    @GetMapping
    public List<SalesChannel> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesChannel> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesChannel create(@RequestBody SalesChannel entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public SalesChannel update(@PathVariable String id, @RequestBody SalesChannel entity) {
        entity.setChannelId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
