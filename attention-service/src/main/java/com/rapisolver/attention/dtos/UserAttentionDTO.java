package com.rapisolver.attention.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserAttentionDTO {
    private Long id;
    private BigDecimal price;
    private String detail;
    private AttentionDTO attention;
}
