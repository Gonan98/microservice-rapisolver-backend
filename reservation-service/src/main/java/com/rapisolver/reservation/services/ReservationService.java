package com.rapisolver.reservation.services;

import com.rapisolver.reservation.dtos.CreateReservationDTO;
import com.rapisolver.reservation.dtos.ReservationDTO;

public interface ReservationService extends CrudService<CreateReservationDTO, ReservationDTO, Long> {
}
