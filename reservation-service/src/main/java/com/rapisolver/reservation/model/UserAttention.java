package com.rapisolver.reservation.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserAttention {
    private Long id;
    private BigDecimal price;
    private String detail;
    private Attention attention;
    private User user;
}
