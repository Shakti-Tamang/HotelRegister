package com.microservices;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableCaching
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.microservices.feignclient")
@OpenAPIDefinition(info = @Info(title = "My API for User Auth ", version = "v1",description = "API for authenticating or registering user"))
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
