package com.microservice.rating;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // Enable service discovery (optional)
@EnableFeignClients(basePackages = "com.microservice.rating.feing")
@OpenAPIDefinition(info = @Info(title = "Rating API",version = "V1",description = "This apis are used for providing rating to the Hotel"))
public class RatingApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class,args);
    }
}
