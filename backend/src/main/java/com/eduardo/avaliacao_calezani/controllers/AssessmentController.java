package com.eduardo.avaliacao_calezani.controllers;

import com.eduardo.avaliacao_calezani.dtos.AssessmentDTO;
import com.eduardo.avaliacao_calezani.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/assessments")
public class AssessmentController {

    private final AssessmentService service;

    @Autowired
    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AssessmentDTO> create(@RequestBody AssessmentDTO dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
