package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private boolean canPublish;
}
