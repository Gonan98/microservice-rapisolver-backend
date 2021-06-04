package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class Score {
    private Long id;
    private Integer mark;
    private String note;
    private UserAttention userAttention;
    private User user;
}
