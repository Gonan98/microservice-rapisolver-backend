package com.rapisolver.reservation.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
