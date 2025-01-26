package com.microservice.rating.controller;

import com.microservice.rating.entities.HotelRatingModel;
import com.microservice.rating.reponse.ApiResponse;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/saveRatings")
    public ResponseEntity<ApiResponse> saveRatings(@RequestBody HotelRatingModel hotelRatingModel) {

        ratingService.saveRating(hotelRatingModel);
        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

    @GetMapping("/getAllHotel")
    public ResponseEntity<ApiResponse> getAllRatings() {
        List<HotelRatingModel> list = ratingService.getAllHotelRating();

        ApiResponse apiResponse = ApiResponse.<HotelRatingModel>builder().statusCode(HttpStatus.OK.value()).list(list).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

//    Without specifying the path variable name (@PathVariable String hotelId), Spring uses the
//    method parameter name.
//    With specifying the path variable name (@PathVariable("ratingId") String ratingId), you can
//    map a path variable with a different name from the URL to the method parameter.



    @GetMapping("/getAllHotelRating/{hotelId}")
    public ResponseEntity<ApiResponse> geAllRatingsByHotelId(@PathVariable String hotelId) {
        List<HotelRatingModel> list = ratingService.getAllByHotelId(hotelId);
        ApiResponse apiResponse = ApiResponse.<HotelRatingModel>builder().statusCode(HttpStatus.OK.value()).list(list).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getAllHotelRating/{userId}")
    public ResponseEntity<ApiResponse> geAllRatingsByUserId(@PathVariable String userId) {
        List<HotelRatingModel> list = ratingService.getAllByUserId(userId);
        ApiResponse apiResponse = ApiResponse.<HotelRatingModel>builder().statusCode(HttpStatus.OK.value()).list(list).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
