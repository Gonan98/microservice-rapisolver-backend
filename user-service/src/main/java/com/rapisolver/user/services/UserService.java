package com.rapisolver.user.services;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO) throws RuntimeException;
    List<UserDTO> getAll() throws RuntimeException;
    UserDTO getById(Long id) throws RuntimeException;
    String deleteById(Long id) throws RuntimeException;

}
