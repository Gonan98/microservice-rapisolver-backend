package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class Attention {
    private Long id;
    private String name;
    private Category category;
}
