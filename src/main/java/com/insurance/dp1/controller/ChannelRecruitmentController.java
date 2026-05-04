package com.insurance.dp1.controller;

import com.insurance.dp1.entity.ChannelRecruitment;
import com.insurance.dp1.service.ChannelRecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channel-recruitments")
@RequiredArgsConstructor
public class ChannelRecruitmentController {

    private final ChannelRecruitmentService service;

    @GetMapping
    public List<ChannelRecruitment> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChannelRecruitment> findById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChannelRecruitment create(@RequestBody ChannelRecruitment entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ChannelRecruitment update(@PathVariable String id, @RequestBody ChannelRecruitment entity) {
        entity.setRecruitmentNo(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
