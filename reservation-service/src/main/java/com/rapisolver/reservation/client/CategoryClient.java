package com.rapisolver.reservation.client;

import com.rapisolver.reservation.controllers.RapisolverResponse;
import com.rapisolver.reservation.model.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "category-service")
@RequestMapping(value = "/api/categories")
public interface CategoryClient {

    @GetMapping("/{id}")
    RapisolverResponse<CategoryDTO> getCategory(@PathVariable Long id);
}
