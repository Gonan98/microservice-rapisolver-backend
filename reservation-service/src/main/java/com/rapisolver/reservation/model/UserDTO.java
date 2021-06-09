package com.rapisolver.reservation.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;
    private RoleDTO role;
}
