package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.AttentionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "attention-service")
@RequestMapping(value = "/api/attentions")
public interface AttentionClient {

    @GetMapping("/{id}")
    RapisolverResponse<AttentionDTO> getAttention(@PathVariable Long id);

}
