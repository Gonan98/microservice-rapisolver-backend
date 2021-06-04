package com.rapisolver.attention.models;

import lombok.Data;

@Data
public class Role {
    private Long id;
    private String name;
    private boolean canPublish;
}
