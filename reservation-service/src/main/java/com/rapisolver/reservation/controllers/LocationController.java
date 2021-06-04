package com.rapisolver.reservation.controllers;

import com.rapisolver.reservation.dtos.CreateLocationDTO;
import com.rapisolver.reservation.dtos.LocationDTO;
import com.rapisolver.reservation.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<LocationDTO> create(@RequestBody CreateLocationDTO createLocationDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Localizacion creada correctamente", service.create(createLocationDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<LocationDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de categorias",service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<LocationDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Localizacion encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<LocationDTO> update(@PathVariable Long id, CreateLocationDTO createLocationDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Localizacion actualizada correctamente", service.update(id, createLocationDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK",service.deleteById(id));
    }

}
