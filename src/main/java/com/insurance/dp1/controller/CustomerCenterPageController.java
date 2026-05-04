package com.insurance.dp1.controller;

import com.insurance.dp1.entity.CustomerCenterPage;
import com.insurance.dp1.service.CustomerCenterPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-center-pages")
@RequiredArgsConstructor
public class CustomerCenterPageController {

    private final CustomerCenterPageService service;

    @GetMapping
    public List<CustomerCenterPage> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerCenterPage> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerCenterPage create(@RequestBody CustomerCenterPage entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public CustomerCenterPage update(@PathVariable Long id, @RequestBody CustomerCenterPage entity) {
        entity.setId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
