package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.AttentionDTO;
import com.rapisolver.reservation.model.CategoryDTO;
import com.rapisolver.reservation.model.ScoreDTO;
import com.rapisolver.reservation.model.UserAttentionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "attention-service")
public interface AttentionClient {

    @GetMapping("api/attentions/{id}")
    RapisolverResponse<AttentionDTO> getAttention(@PathVariable Long id);

    @GetMapping("api/user-attentions/{id}")
    RapisolverResponse<UserAttentionDTO> getUserAttention(@PathVariable Long id);

    @GetMapping("api/scores/{id}")
    RapisolverResponse<ScoreDTO> getScore(@PathVariable Long id);

    @GetMapping("api/categories/{id}")
    RapisolverResponse<CategoryDTO> getCategory(@PathVariable Long id);
}
