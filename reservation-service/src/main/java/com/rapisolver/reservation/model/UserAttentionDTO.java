package com.rapisolver.reservation.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserAttentionDTO {
    private Long id;
    private BigDecimal price;
    private String detail;
    private AttentionDTO attention;
    private UserDTO user;
}
