package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.Score;
import com.rapisolver.reservation.model.UserAttention;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "attention-service")
@RequestMapping(value = "/api/user-attentions")
public interface UserAttentionClient {

    @GetMapping("/{id}")
    RapisolverResponse<UserAttention> getUserAttention(@PathVariable Long id);

}
