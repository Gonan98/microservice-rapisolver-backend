package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.CreateScoreDTO;
import com.rapisolver.attention.dtos.ScoreDTO;
import com.rapisolver.attention.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<ScoreDTO> create(@RequestBody CreateScoreDTO createScoreDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"Calificacion creada correctamente", service.create(createScoreDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<ScoreDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"Lista de calificaciones", service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<ScoreDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Calificacion encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<ScoreDTO> update(@PathVariable Long id, @RequestBody CreateScoreDTO createScoreDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"Calificacion actualizada correctamente", service.update(id, createScoreDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<ScoreDTO> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Calificacion eliminada", service.deleteById(id));
    }
}
