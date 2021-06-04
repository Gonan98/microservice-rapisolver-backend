package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.Attention;
import com.rapisolver.reservation.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "attention-service")
@RequestMapping(value = "/api/categories")
public interface CategoryClient {

    @GetMapping("/{id}")
    RapisolverResponse<Category> getCategory(@PathVariable Long id);
}
