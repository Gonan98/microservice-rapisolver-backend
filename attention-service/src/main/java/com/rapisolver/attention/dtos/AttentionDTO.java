package com.rapisolver.attention.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttentionDTO {
    private Long id;
    private String name;
    private String status;
    private CategoryDTO category;
}
