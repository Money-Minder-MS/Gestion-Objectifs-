package com.example.gestion_objectif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class GestionObjectifApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionObjectifApplication.class, args);
    }

}
