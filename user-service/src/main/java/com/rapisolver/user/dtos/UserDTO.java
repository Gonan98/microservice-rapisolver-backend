package com.rapisolver.user.dtos;

import com.rapisolver.user.enums.Status;
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
    private Status status;
    private Date createdAt;
    private RoleDTO role;
}
