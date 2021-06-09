package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.ScoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "score-service")
@RequestMapping(value = "/api/scores")
public interface ScoreClient {

    @GetMapping("/{id}")
    RapisolverResponse<ScoreDTO> getScore(@PathVariable Long id);

}
