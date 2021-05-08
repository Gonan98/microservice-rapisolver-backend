package com.rapisolver.user.services;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.UserDTO;
import com.rapisolver.user.exceptions.RapisolverException;

import java.util.List;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO) throws RapisolverException;
    List<UserDTO> getAll() throws RapisolverException;
    UserDTO getById(Long id) throws RapisolverException;
    String deleteById(Long id) throws RapisolverException;

}
