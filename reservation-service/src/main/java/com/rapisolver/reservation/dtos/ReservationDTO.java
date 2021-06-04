package com.rapisolver.reservation.dtos;

import com.rapisolver.reservation.util.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private Date datetime;
    private String address;
    private ReservationStatus reservationStatus;
    private LocationDTO location;
    //private UserAttentionDTO userAttention;
    //private UserDTO user;
}
