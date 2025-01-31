package com.microservices.feignclient;


import com.microservices.entity.HotelRatingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
//
//A Feign client in Spring Boot is an HTTP client used to call REST APIs from one microservice
//        to another. It simplifies communication between microservices by making HTTP requests
//        declaratively. With Feign, you define an interface and annotate it, and it
//        automatically generates the implementation for making API calls. It's often used
//        in microservices architectures to handle inter-service communication.


@FeignClient(name = "app2")  // No need for "url" if using Eureka
public interface RatingFiegnService {
    @GetMapping("/ratings/getAllHotelRatingGet/{userId}")
    List<HotelRatingModel> getAllByUserId(@PathVariable("userId") String userId);

    @DeleteMapping("/ratings/deleteByUser/{userId}")
    void deleteRating(@PathVariable("userId") String userId);
}