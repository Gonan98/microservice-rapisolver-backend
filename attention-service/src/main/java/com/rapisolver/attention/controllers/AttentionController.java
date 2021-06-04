package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.AttentionDTO;
import com.rapisolver.attention.dtos.CreateAttentionDTO;
import com.rapisolver.attention.services.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attentions")
public class AttentionController {

    @Autowired
    private AttentionService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<AttentionDTO> create(@RequestBody CreateAttentionDTO createAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Atencion creada correctamente", service.create(createAttentionDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<AttentionDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de atenciones",service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<AttentionDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Atencion encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<AttentionDTO> update(@PathVariable Long id, CreateAttentionDTO createAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Atencion actualizada correctamente", service.update(id, createAttentionDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK",service.deleteById(id));
    }
}
