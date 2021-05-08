package com.rapisolver.user.services.impl;

import com.rapisolver.user.dtos.RoleDTO;
import com.rapisolver.user.exceptions.RapisolverException;
import com.rapisolver.user.repositories.RoleRepository;
import com.rapisolver.user.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRoles() throws RapisolverException {
        return roleRepository.findAll().stream().map(role -> {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
            roleDTO.setCanPublish(role.isCanPublish());
            return roleDTO;
        }).collect(Collectors.toList());
    }
}
