package com.insurance.dp1.controller;

import com.insurance.dp1.entity.Applicant;
import com.insurance.dp1.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService service;

    @GetMapping
    public List<Applicant> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Applicant create(@RequestBody Applicant entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public Applicant update(@PathVariable String id, @RequestBody Applicant entity) {
        entity.setApplicantId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
