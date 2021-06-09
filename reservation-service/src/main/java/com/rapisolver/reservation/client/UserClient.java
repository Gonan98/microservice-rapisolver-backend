package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/*
@FeignClient(name = "user-service")
@RequestMapping(value = "/api/roles")
public interface UserClient {

    @GetMapping("/{id}")
    RapisolverResponse<UserDTO> getUser(@PathVariable Long id);

}*/
