package com.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean

    public RestTemplate restTemplate(){

        RestTemplate restTemplate=new RestTemplate();

        return restTemplate;
    }
}
