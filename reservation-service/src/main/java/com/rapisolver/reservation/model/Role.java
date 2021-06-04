package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String name;
    private boolean canPublish;
}
