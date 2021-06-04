package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.Category;
import com.rapisolver.reservation.model.Score;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "attention-service")
@RequestMapping(value = "/api/scores")
public interface ScoreClient {

    @GetMapping("/{id}")
    RapisolverResponse<Score> getScore(@PathVariable Long id);

}
