package com.rapisolver.user.services;

import com.rapisolver.user.dtos.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO getById(Long id) throws RuntimeException;
    List<RoleDTO> getAllRoles() throws RuntimeException;

}
