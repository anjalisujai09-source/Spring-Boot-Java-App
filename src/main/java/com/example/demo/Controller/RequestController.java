package com.example.demo.Controller;

import com.example.demo.Service.RequestService;
import com.example.demo.dto.SubmitRequestDto;
import com.example.demo.model.RequestEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api/requests",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class RequestController {

    private final RequestService service;

    @PostMapping
    public ResponseEntity<Long> submit(
            @Valid @RequestBody SubmitRequestDto dto) {
        return ResponseEntity.ok(service.submit(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}

