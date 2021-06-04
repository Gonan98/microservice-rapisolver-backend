package com.rapisolver.user.services.impl;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.UserDTO;
import com.rapisolver.user.entities.Role;
import com.rapisolver.user.entities.User;
import com.rapisolver.user.enums.Status;
import com.rapisolver.user.exceptions.InternalServerErrorException;
import com.rapisolver.user.exceptions.NotFoundException;
import com.rapisolver.user.repositories.RoleRepository;
import com.rapisolver.user.repositories.UserRepository;
import com.rapisolver.user.services.UserService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) throws RuntimeException {

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
            return modelMapper.map(user, UserDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_USER_ERROR");
        }
    }

    @Override
    public List<UserDTO> getAll() throws RuntimeException {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(Long id) throws RuntimeException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return modelMapper.map(userDB, UserDTO.class);
    }

    @Override
    public String deleteById(Long id) throws RuntimeException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        try {
            userDB.setStatus(Status.DELETED);
            userRepository.save(userDB);
            return "Usuario eliminado";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_USER_ERROR");
        }
    }
}
