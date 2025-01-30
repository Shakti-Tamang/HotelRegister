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
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "My API for Library Management System", version = "v1",description = "This API enables efficient management of library resources for colleges, allowing users to add, search, and manage book records. It supports role-based access control to ensure that only authorized users, like administrators, can add new books and perform management tasks. Designed for seamless integration, the API streamlines common library functions, enhancing accessibility and organization."))
public class RatingApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class,args);
    }
}
