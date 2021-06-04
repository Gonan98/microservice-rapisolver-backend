package com.rapisolver.reservation.controllers;

import com.rapisolver.reservation.dtos.CreateLocationDTO;
import com.rapisolver.reservation.dtos.CreateReservationDTO;
import com.rapisolver.reservation.dtos.LocationDTO;
import com.rapisolver.reservation.dtos.ReservationDTO;
import com.rapisolver.reservation.services.LocationService;
import com.rapisolver.reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RapisolverResponse<ReservationDTO> create(@RequestBody CreateReservationDTO createReservationDTO) throws RuntimeException {
        return new RapisolverResponse<>(201,"CREATED","Reserva creada correctamente", service.create(createReservationDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RapisolverResponse<List<ReservationDTO>> getAll() throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Lista de reservas",service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RapisolverResponse<ReservationDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Reserva encontrada", service.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RapisolverResponse<ReservationDTO> update(@PathVariable Long id, CreateReservationDTO createReservationDTO) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK","Reserva actualizada correctamente", service.update(id, createReservationDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public RapisolverResponse<String> deleteById(@PathVariable Long id) throws RuntimeException {
        return new RapisolverResponse<>(200,"OK",service.deleteById(id));
    }

}
