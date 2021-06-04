package com.rapisolver.attention.models;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;
    private Role role;
}
