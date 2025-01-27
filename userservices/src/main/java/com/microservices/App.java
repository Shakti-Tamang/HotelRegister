package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // Enable Eureka client registration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
