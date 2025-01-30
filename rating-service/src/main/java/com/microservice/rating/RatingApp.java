package com.microservice.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // Enable service discovery (optional)
@EnableFeignClients

public class RatingApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class,args);
    }
}
