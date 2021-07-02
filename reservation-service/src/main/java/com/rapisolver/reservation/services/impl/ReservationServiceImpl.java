package com.rapisolver.reservation.services.impl;

import com.rapisolver.reservation.client.AttentionClient;
import com.rapisolver.reservation.dtos.CreateReservationDTO;
import com.rapisolver.reservation.dtos.ReservationDTO;
import com.rapisolver.reservation.entities.Location;
import com.rapisolver.reservation.entities.Reservation;
import com.rapisolver.reservation.exceptions.InternalServerErrorException;
import com.rapisolver.reservation.exceptions.NotFoundException;
import com.rapisolver.reservation.repositories.LocationRepository;
import com.rapisolver.reservation.repositories.ReservationRepository;
import com.rapisolver.reservation.services.ReservationService;
import com.rapisolver.reservation.util.ReservationStatus;
import com.rapisolver.reservation.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private AttentionClient attentionClient;

    @Override
    public ReservationDTO create(CreateReservationDTO t) throws RuntimeException {
        Location locationDB = locationRepository.findById(t.getLocationId()).orElseThrow(() -> new NotFoundException("LOCATION_NOT_FOUND"));
        if (attentionClient.getUserAttention(t.getUserAttentionId()).getData() == null)
            throw new NotFoundException("La atencion del proveedor no existe");

        try {
            Reservation reservation = new Reservation();
            reservation.setDatetime(t.getDatetime());
            reservation.setAddress(t.getAddress());
            reservation.setLocation(locationDB);
            reservation.setCreatedAt(new Date());
            reservation.setReservationStatus(ReservationStatus.ACTIVE);
            reservation.setStatus(String.valueOf(Status.CREATED));
            reservation.setUserAttentionId(t.getUserAttentionId());
            reservation.setUserId(t.getUserId());
            reservation = repository.save(reservation);
            return mapper.map(reservation, ReservationDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("CREATE_RESERVATION_ERROR");
        }
    }

    @Override
    public List<ReservationDTO> getAll() throws RuntimeException {
        List<Reservation> reservations = repository.findAll();
        return reservations.stream().map(c -> mapper.map(c, ReservationDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getById(Long aLong) throws RuntimeException {
        Reservation reservationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Reserva con id="+aLong+" no encontrada"));
        return mapper.map(reservationDB, ReservationDTO.class);
    }

    @Override
    public ReservationDTO update(Long aLong, CreateReservationDTO t) throws RuntimeException {
        Location locationDB = locationRepository.findById(t.getLocationId()).orElseThrow(() -> new NotFoundException("LOCATION_NOT_FOUND"));
        Reservation reservationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Reserva con id="+aLong+" no encontrada"));

        try {
            reservationDB.setStatus(String.valueOf(Status.UPDATED));
            reservationDB.setDatetime(t.getDatetime());
            reservationDB.setAddress(t.getAddress());
            reservationDB.setLocation(locationDB);
            reservationDB.setReservationStatus(t.getReservationStatus());
            reservationDB = repository.save(reservationDB);
            return mapper.map(reservationDB, ReservationDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_RESERVATION_ERROR");
        }
    }

    @Override
    public String deleteById(Long aLong) throws RuntimeException {
        Reservation reservationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Reserva con id="+aLong+" no encontrada"));

        try {
            reservationDB.setStatus(String.valueOf(Status.DELETED));
            reservationDB.setReservationStatus(ReservationStatus.CANCELLED);
            repository.save(reservationDB);
            return "Reserva eliminada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_RESERVATION_ERROR");
        }
    }
}
