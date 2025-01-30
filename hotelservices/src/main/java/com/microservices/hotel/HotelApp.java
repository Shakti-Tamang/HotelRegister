package com.microservices.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // Enable Feign in User Service
@EnableDiscoveryClient // Enable service discovery (optional)
public class HotelApp {
    public static void main(String[] args) {
        SpringApplication.run(HotelApp.class,args);

    }
}
