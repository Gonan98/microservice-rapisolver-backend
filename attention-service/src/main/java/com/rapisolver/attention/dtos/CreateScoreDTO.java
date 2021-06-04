package com.rapisolver.attention.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScoreDTO {
    private Integer mark;
    private String note;
    private Long userId;
    private Long userAttentionId;
}
