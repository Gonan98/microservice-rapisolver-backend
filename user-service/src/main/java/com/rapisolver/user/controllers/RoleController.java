package com.rapisolver.user.controllers;

import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.exceptions.RapisolverException;
import com.rapisolver.user.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<RoleDTO>> getAll() throws RapisolverException {
        return new RapisolverResponse<>(200,"OK","Listado de roles", roleService.getAllRoles());
    }

}
