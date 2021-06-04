package com.rapisolver.reservation.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private Long id;
    private String country;
    private String state;
    private String city;
}
