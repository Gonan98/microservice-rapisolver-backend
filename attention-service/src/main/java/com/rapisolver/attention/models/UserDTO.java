package com.rapisolver.attention.models;

import com.rapisolver.attention.util.Status;
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
    private Status status;
    private Date createdAt;
    private Date birthdate;
    private RoleDTO role;
}
