package com.rapisolver.user.services;

import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.exceptions.RapisolverException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAllRoles() throws RapisolverException;

}
