package com.rapisolver.attention.controllers;

import com.rapisolver.attention.dtos.AttentionDTO;
import com.rapisolver.attention.dtos.CategoryDTO;
import com.rapisolver.attention.dtos.CreateAttentionDTO;
import com.rapisolver.attention.dtos.CreateCategoryDTO;
import com.rapisolver.attention.services.AttentionService;
import com.rapisolver.attention.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<CategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Categoria creada correctamente", service.create(createCategoryDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<CategoryDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de categorias",service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<CategoryDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Categoria encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<CategoryDTO> update(@PathVariable Long id, CreateCategoryDTO createCategoryDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Categoria actualizada correctamente", service.update(id, createCategoryDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK",service.deleteById(id));
    }
}
