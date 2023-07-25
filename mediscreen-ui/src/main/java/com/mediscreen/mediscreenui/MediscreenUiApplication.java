package com.mediscreen.mediscreenui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mediscreen.mediscreenui")
public class MediscreenUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediscreenUiApplication.class, args);
    }

}
