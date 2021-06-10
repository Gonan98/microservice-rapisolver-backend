package com.rapisolver.user.services.impl;

import com.rapisolver.user.dtos.CreateUserDTO;
import com.rapisolver.user.dtos.UserDTO;
import com.rapisolver.user.entities.Role;
import com.rapisolver.user.entities.User;
import com.rapisolver.user.enums.Status;
import com.rapisolver.user.exceptions.BadRequestException;
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

        Role role = roleRepository.findByName("ROLE_CUSTOMER").orElseThrow(() -> new NotFoundException("ROLE_CUSTOMER_NOT_FOUND"));

        User user = new User();
        user.setCreatedAt(new Date());
        user.setStatus(String.valueOf(Status.CREATED));
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
    public UserDTO deleteById(Long id) throws RuntimeException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        try {
            userDB.setStatus(String.valueOf(Status.DELETED));
            userDB = userRepository.save(userDB);
            return modelMapper.map(userDB, UserDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_USER_ERROR");
        }
    }

    @Override
    public String buySubscription(Long id) throws RuntimeException {
        User userDB = userRepository.findById(id).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));

        if (userDB.getRole().isCanPublish())
            throw new BadRequestException("USER_ALREADY_HAS_A_SUBSCRIPTION");

        Role roleDB = roleRepository.findByName("ROLE_SUPPLIER").orElseThrow(() -> new NotFoundException("ROLE_SUPPLIER_NOT_FOUND"));

        try {
            userDB.setRole(roleDB);
            userDB.setStatus(String.valueOf(Status.UPDATED));
            userRepository.save(userDB);
            return "Subscripcion pagada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("BUY_SUBSCRIPTION_ERROR");
        }
    }
}
