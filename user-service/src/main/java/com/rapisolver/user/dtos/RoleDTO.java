package com.rapisolver.user.dtos;

import lombok.*;

@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;
    private boolean canPublish;
}
