package com.mediscreen.diabetesdetectorapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.mediscreen.diabetesdetectorapi")
public class DiabetesDetectorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiabetesDetectorApiApplication.class, args);

    }
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
