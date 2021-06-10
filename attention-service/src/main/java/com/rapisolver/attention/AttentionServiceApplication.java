package com.rapisolver.attention;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AttentionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttentionServiceApplication.class, args);
    }

}
