package com.nextstep.microservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer  // Enable Eureka Server
//status different registry
//service registery service discovery
@EnableFeignClients  // Enable Feign in User Service
@EnableDiscoveryClient // Enable service discovery (optional)
@OpenAPIDefinition(info = @Info(title = "API for HotelServices",version = "V1",description = "Api for resitering the hotel"))
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }
}
