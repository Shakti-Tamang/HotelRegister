package com.microservices.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableFeignClients
public class HotelApp {
    public static void main(String[] args) {
        SpringApplication.run(HotelApp.class,args);
    }
}
