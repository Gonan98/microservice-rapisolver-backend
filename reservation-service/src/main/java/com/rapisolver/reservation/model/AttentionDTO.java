package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class AttentionDTO {
    private Long id;
    private String name;
    private CategoryDTO category;
}
