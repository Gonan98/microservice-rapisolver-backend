package com.rapisolver.user.services;

import com.rapisolver.user.dtos.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAllRoles() throws RuntimeException;

}
