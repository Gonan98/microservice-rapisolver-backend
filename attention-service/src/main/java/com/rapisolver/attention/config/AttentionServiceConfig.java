package com.rapisolver.attention.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AttentionServiceConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
