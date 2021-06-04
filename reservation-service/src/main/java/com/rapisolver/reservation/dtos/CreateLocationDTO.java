package com.rapisolver.reservation.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLocationDTO {
    private String country;
    private String state;
    private String city;
}
