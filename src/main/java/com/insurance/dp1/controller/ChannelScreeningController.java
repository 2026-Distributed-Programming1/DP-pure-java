package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ChannelScreening;
import com.insurance.dp1.service.ChannelScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channel-screenings")
@RequiredArgsConstructor
public class ChannelScreeningController {

    private final ChannelScreeningService service;

    @GetMapping
    public List<ChannelScreening> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelScreening> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChannelScreening create(@RequestBody ChannelScreening entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ChannelScreening update(@PathVariable String id, @RequestBody ChannelScreening entity) {
        entity.setApprovalNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
