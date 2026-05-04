package com.insurance.dp1.controller;

import com.insurance.dp1.entity.CustomerRegistration;
import com.insurance.dp1.service.CustomerRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-registrations")
@RequiredArgsConstructor
public class CustomerRegistrationController {

    private final CustomerRegistrationService service;

    @GetMapping
    public List<CustomerRegistration> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRegistration> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerRegistration create(@RequestBody CustomerRegistration entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public CustomerRegistration update(@PathVariable String id, @RequestBody CustomerRegistration entity) {
        entity.setCustomerId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
