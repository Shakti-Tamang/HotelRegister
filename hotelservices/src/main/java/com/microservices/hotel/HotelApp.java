package com.microservices.hotel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "API for HotelServices",version = "V1",description = "Api for resitering the hotel"))
public class HotelApp{
//    public void sum(){
//        cannot use acess modifier because it is accessible within the function
//        public int l=0;
//    }
    public static void main(String[] args) {
        SpringApplication.run(HotelApp.class,args);
    }
}
