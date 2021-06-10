package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.CreateScoreDTO;
import com.rapisolver.attention.dtos.CreateUserAttentionDTO;
import com.rapisolver.attention.dtos.ScoreDTO;
import com.rapisolver.attention.dtos.UserAttentionDTO;
import com.rapisolver.attention.services.ScoreService;
import com.rapisolver.attention.services.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-attentions")
public class UserAttentionController {

    @Autowired
    private UserAttentionService service;

    @PostMapping
    public RapisolverResponse<UserAttentionDTO> create(@RequestBody CreateUserAttentionDTO createUserAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"Atencion de proveedor creada correctamente", service.create(createUserAttentionDTO));
    }

    @GetMapping
    public RapisolverResponse<List<UserAttentionDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"Lista de atenciones de proveedor", service.getAll());
    }

    @GetMapping("/{id}")
    public RapisolverResponse<UserAttentionDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Atencion de proveedor encontrada", service.getById(id));
    }

    @PutMapping("/{id}")
    public RapisolverResponse<UserAttentionDTO> update(@PathVariable Long id, @RequestBody CreateUserAttentionDTO createUserAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"Atencion de proveedor actualizada", service.update(id, createUserAttentionDTO));
    }

    @DeleteMapping("/{id}")
    public RapisolverResponse<UserAttentionDTO> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Atencion de proveedor eliminada", service.deleteById(id));
    }
}
