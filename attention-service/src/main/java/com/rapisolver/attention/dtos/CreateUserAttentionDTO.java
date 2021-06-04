package com.rapisolver.attention.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateUserAttentionDTO {
    private BigDecimal price;
    private String detail;
    private Long userId;
    private Long attentionId;
}
