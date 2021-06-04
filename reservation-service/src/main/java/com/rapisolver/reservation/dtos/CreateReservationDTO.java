package com.rapisolver.reservation.dtos;

import com.rapisolver.reservation.util.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateReservationDTO {
    private Date datetime;
    private String address;
    private ReservationStatus reservationStatus;
    private Long locationId;
    //private Long userAttentionId;
    //private Long userId;
}
