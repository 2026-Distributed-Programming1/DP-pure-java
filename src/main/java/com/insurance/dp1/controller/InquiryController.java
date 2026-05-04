package com.insurance.dp1.controller;

import com.insurance.dp1.entity.Inquiry;
import com.insurance.dp1.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService service;

    @GetMapping
    public List<Inquiry> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquiry> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inquiry create(@RequestBody Inquiry entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public Inquiry update(@PathVariable String id, @RequestBody Inquiry entity) {
        entity.setInquiryNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
