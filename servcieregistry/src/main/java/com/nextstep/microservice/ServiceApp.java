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
@OpenAPIDefinition(info = @Info(title = "My API for Library Management System", version = "v1",description = "This API enables efficient management of library resources for colleges, allowing users to add, search, and manage book records. It supports role-based access control to ensure that only authorized users, like administrators, can add new books and perform management tasks. Designed for seamless integration, the API streamlines common library functions, enhancing accessibility and organization."))
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }
}
