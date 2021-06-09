package com.rapisolver.attention.client;

import com.rapisolver.attention.controllers.RapisolverResponse;
import com.rapisolver.attention.models.RoleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "role-service")
@RequestMapping(value = "/api/roles")
public interface RoleClient {

    @GetMapping("/{id}")
    RapisolverResponse<RoleDTO> getRole(@PathVariable Long id);

}
