package com.microservices.feignclient;


import com.microservices.entity.HotelRatingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("app2")  // No need for "url" if using Eureka
public interface RatingFiegnService {
    @GetMapping("/getAllHotelRatingGet")
    List<HotelRatingModel> getAllByUserId(@RequestParam("userId") String userId);

}
