package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.RoleDTO;
import com.rapisolver.reservation.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/roles/{id}")
    RapisolverResponse<UserDTO> getUser(@PathVariable Long id);

    @GetMapping("/api/users/{id}")
    RapisolverResponse<RoleDTO> getRole(@PathVariable Long id);

}
