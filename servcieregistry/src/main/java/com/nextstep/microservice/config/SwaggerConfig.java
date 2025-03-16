package com.nextstep.microservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservices API Gateway")
                        .version("1.0")
                        .description("Aggregated API documentation for all microservices"))
                .servers(List.of(
                        new Server().url("http://localhost:8079").description("app3"),
                        new Server().url("http://localhost:8092").description("app4"),
                        new Server().url("http://localhost:8093").description("app2"),
                        new Server().url("http://localhost:8089").description("app1"),
                        new Server().url("http://localhost:8069").description("app6")
                ));
    }
}