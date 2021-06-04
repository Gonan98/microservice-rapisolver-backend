package com.rapisolver.reservation.services.impl;

import com.rapisolver.reservation.dtos.CreateLocationDTO;
import com.rapisolver.reservation.dtos.LocationDTO;
import com.rapisolver.reservation.entities.Location;
import com.rapisolver.reservation.exceptions.InternalServerErrorException;
import com.rapisolver.reservation.exceptions.NotFoundException;
import com.rapisolver.reservation.repositories.LocationRepository;
import com.rapisolver.reservation.services.LocationService;
import com.rapisolver.reservation.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LocationRepository repository;

    @Override
    public LocationDTO create(CreateLocationDTO t) throws RuntimeException {
        try {
            Location location = new Location();
            location.setCountry(t.getCountry());
            location.setState(t.getState());
            location.setCity(t.getCity());
            location.setStatus(Status.CREATED);
            location.setCreatedAt(new Date());
            location = repository.save(location);
            return mapper.map(location, LocationDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_CATEGORY_ERROR");
        }
    }

    @Override
    public List<LocationDTO> getAll() throws RuntimeException {
        List<Location> locations = repository.findAll();
        return locations.stream().map(c -> mapper.map(c, LocationDTO.class)).collect(Collectors.toList());
    }

    @Override
    public LocationDTO getById(Long aLong) throws RuntimeException {
        Location locationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Location con id="+aLong+" no encontrado"));
        return mapper.map(locationDB, LocationDTO.class);
    }

    @Override
    public LocationDTO update(Long aLong, CreateLocationDTO t) throws RuntimeException {
        Location locationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Location con id="+aLong+" no encontrado"));

        try {
            locationDB.setCountry(t.getCountry());
            locationDB.setState(t.getState());
            locationDB.setCity(t.getCity());
            locationDB.setStatus(Status.UPDATED);
            locationDB = repository.save(locationDB);
            return mapper.map(locationDB, LocationDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_CATEGORY_ERROR");
        }
    }

    @Override
    public String deleteById(Long aLong) throws RuntimeException {
        Location locationDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("Location con id="+aLong+" no encontrado"));

        try {
            locationDB.setStatus(Status.DELETED);
            repository.save(locationDB);
            return "Localizacion eliminada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_LOCATION_ERROR");
        }
    }
}
