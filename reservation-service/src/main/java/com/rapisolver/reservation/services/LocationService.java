package com.rapisolver.reservation.services;

import com.rapisolver.reservation.dtos.CreateLocationDTO;
import com.rapisolver.reservation.dtos.LocationDTO;

public interface LocationService extends CrudService<CreateLocationDTO, LocationDTO, Long> {
}
