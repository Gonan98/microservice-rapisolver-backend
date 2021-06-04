package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.CreateScoreDTO;
import com.rapisolver.attention.dtos.CreateUserAttentionDTO;
import com.rapisolver.attention.dtos.ScoreDTO;
import com.rapisolver.attention.dtos.UserAttentionDTO;
import com.rapisolver.attention.services.ScoreService;
import com.rapisolver.attention.services.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-attentions")
public class UserAttentionController {

    @Autowired
    private UserAttentionService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<UserAttentionDTO> create(@RequestBody CreateUserAttentionDTO createUserAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Categoria creada correctamente", service.create(createUserAttentionDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<UserAttentionDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de categorias",service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<UserAttentionDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Categoria encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<UserAttentionDTO> update(@PathVariable Long id, CreateUserAttentionDTO createUserAttentionDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Categoria actualizada correctamente", service.update(id, createUserAttentionDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK",service.deleteById(id));
    }
}
