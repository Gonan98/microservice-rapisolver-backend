package com.rapisolver.user.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;
    private String status;
    private Date createdAt;
    private RoleDTO role;
}
