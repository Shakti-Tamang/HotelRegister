package com.nextstep.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow Swagger UI (running on 8016) to access API documentation of all services
        registry.addMapping("/v3/api-docs/**")
                .allowedOrigins("http://localhost:8016") // Allow requests from Swagger UI
                .allowedMethods("GET")
                .allowCredentials(true);
    }
}
