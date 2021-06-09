package com.rapisolver.reservation.model;

import lombok.Data;

@Data
public class ScoreDTO {
    private Long id;
    private Integer mark;
    private String note;
    private UserAttentionDTO userAttention;
    private UserDTO user;
}
