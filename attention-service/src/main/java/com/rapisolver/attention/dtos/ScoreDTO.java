package com.rapisolver.attention.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDTO {
    private Long id;
    private Integer mark;
    private String note;
    private UserAttentionDTO userAttention;
}
