package com.rapisolver.attention.client;

import com.rapisolver.attention.controllers.RapisolverResponse;
import com.rapisolver.attention.models.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
@RequestMapping(value = "/api/roles")
public interface RoleClient {

    @GetMapping("/{id}")
    RapisolverResponse<Role> getRole(@PathVariable Long id);

}
