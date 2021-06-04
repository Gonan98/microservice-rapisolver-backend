package com.rapisolver.user.controllers;

import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<RoleDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Listado de roles", roleService.getAllRoles());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<RoleDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Rol encontrado", roleService.getById(id));
    }

}
