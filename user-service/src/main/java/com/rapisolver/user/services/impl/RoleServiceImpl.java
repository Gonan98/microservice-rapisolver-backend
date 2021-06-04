package com.rapisolver.user.services.impl;

import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.entities.Role;
import com.rapisolver.user.exceptions.NotFoundException;
import com.rapisolver.user.repositories.RoleRepository;
import com.rapisolver.user.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO getById(Long id) throws RuntimeException {
        Role roleDB = roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Rol con Id="+id+" no encontrado"));
        return modelMapper.map(roleDB, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAllRoles() throws RuntimeException {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(r -> modelMapper.map(r, RoleDTO.class)).collect(Collectors.toList());
    }
}
