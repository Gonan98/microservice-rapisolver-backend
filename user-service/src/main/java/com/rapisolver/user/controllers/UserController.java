package com.rapisolver.user.controllers;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.UserDTO;
import com.rapisolver.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<UserDTO> create(@Valid @RequestBody CreateUserDTO createUserDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Usuario creado correctamente", userService.create(createUserDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<UserDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de usuarios", userService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<UserDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Usuario encontrado", userService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK", userService.deleteById(id));
    }
}
