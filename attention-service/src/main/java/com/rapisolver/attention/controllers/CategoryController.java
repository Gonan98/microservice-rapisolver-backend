package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.CategoryDTO;
import com.rapisolver.attention.dtos.CreateCategoryDTO;
import com.rapisolver.attention.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public RapisolverResponse<CategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"Categoria creada correctamente", service.create(createCategoryDTO));
    }

    @GetMapping
    public RapisolverResponse<List<CategoryDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"Lista de categorias", service.getAll());
    }

    @GetMapping("/{id}")
    public RapisolverResponse<CategoryDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Categoria encontrada", service.getById(id));
    }

    @PutMapping("/{id}")
    public RapisolverResponse<CategoryDTO> update(@PathVariable Long id, @RequestBody CreateCategoryDTO createCategoryDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"Categoria actualizada correctamente", service.update(id, createCategoryDTO));
    }

    @DeleteMapping("/{id}")
    public RapisolverResponse<CategoryDTO> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"Categoria eliminada", service.deleteById(id));
    }
}
