package com.rapisolver.attention.client;

import com.rapisolver.attention.controllers.RapisolverResponse;
import com.rapisolver.attention.models.RoleDTO;
import com.rapisolver.attention.models.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    RapisolverResponse<UserDTO> getUser(@PathVariable Long id);

    @GetMapping("/api/roles/{id}")
    RapisolverResponse<RoleDTO> getRole(@PathVariable Long id);
}
