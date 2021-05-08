package com.rapisolver.user.services.impl;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.dtos.UserDTO;
import com.rapisolver.user.entities.Role;
import com.rapisolver.user.entities.User;
import com.rapisolver.user.enums.Status;
import com.rapisolver.user.exceptions.InternalServerErrorException;
import com.rapisolver.user.exceptions.RapisolverException;
import com.rapisolver.user.repositories.RoleRepository;
import com.rapisolver.user.repositories.UserRepository;
import com.rapisolver.user.services.UserService;
import com.sun.jersey.api.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) throws RapisolverException {

        Role role = roleRepository.findById(1L).orElseThrow(() -> new NotFoundException("ROLE_NOT_FOUND"));

        User user = new User();
        user.setCreatedAt(new Date());
        user.setStatus(Status.CREATED);
        user.setFirstname(createUserDTO.getFirstname());
        user.setLastname(createUserDTO.getLastname());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setBirthdate(createUserDTO.getBirthdate());
        user.setPhone(createUserDTO.getPhone());
        user.setRole(role);

        try {
            user = userRepository.save(user);
            return mappedToDTO(user);

        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_USER_ERROR");
        }
    }

    @Override
    public List<UserDTO> getAll() throws RapisolverException {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mappedToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(Long id) throws RapisolverException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return mappedToDTO(userDB);
    }

    @Override
    public String deleteById(Long id) throws RapisolverException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));

        try {
            userDB.setStatus(Status.DELETED);
            userRepository.save(userDB);
            return "Usuario eliminado";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_USER_ERROR");
        }
    }

    private UserDTO mappedToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setStatus(user.getStatus());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setBirthdate(user.getBirthdate());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(user.getRole().getId());
        roleDTO.setName(user.getRole().getName());
        roleDTO.setCanPublish(user.getRole().isCanPublish());

        userDTO.setRole(roleDTO);

        return userDTO;
    }
}
