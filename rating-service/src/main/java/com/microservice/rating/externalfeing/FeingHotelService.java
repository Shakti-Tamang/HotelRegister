package com.microservice.rating.externalfeing;

import com.microservice.rating.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "app3")
public interface FeingHotelService {

    @GetMapping("/hotels/getHotel/{id}")
    public Hotel getByHotelId(@PathVariable("id") String id);
}

