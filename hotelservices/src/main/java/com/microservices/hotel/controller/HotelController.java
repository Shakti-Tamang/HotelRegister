package com.microservices.hotel.controller;

import com.microservices.hotel.entites.Hotel;
import com.microservices.hotel.response.ApiResponse;
import com.microservices.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:8016")  // Allow requests from Swagger UI
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //layered architecture and Multimodule
//    dividing projects into different module
//layerd is dividing business databse logic differently
    @PostMapping("/posthotel")
    public ResponseEntity<ApiResponse> saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") String id) {
        Hotel hotel = hotelService.getHotelById(id);
    ApiResponse apiResponse=ApiResponse.<Hotel>builder().message("success").statusCode(HttpStatus.OK.value()).data(hotel).build();

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
