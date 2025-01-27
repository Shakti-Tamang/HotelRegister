package com.microservice.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class,args);
    }
}
