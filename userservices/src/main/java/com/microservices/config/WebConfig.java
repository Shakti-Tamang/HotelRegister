package com.microservices.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow Swagger UI (app1) to access API docs from app4
        registry.addMapping("/v3/api-docs/**")
                .allowedOrigins("http://localhost:8016") // Adjust to the Swagger UI location
                .allowedMethods("GET")
                .allowCredentials(true);
    }
}