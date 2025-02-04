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
@CrossOrigin(origins = "http://localhost:8001")
public class RatingController {

    @Autowired
    private RatingService ratingService;

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

    @GetMapping("/getAllHotelRatingGet/{userId}")
    public ResponseEntity<List<HotelRatingModel>> getAllHotelRating(@PathVariable("userId") String userId) {
        List<HotelRatingModel> ratings = ratingService.getAllByUserId(userId);
        if (ratings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ratings);

//        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
//
//        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/deleteByUser/{userId}")
    public ResponseEntity<ApiResponse> deleteRating(@PathVariable("userId") String userId) {
        ratingService.deleteUser(userId);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("Ratings successfully deleted")
                .statusCode(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getRating/{ratingId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("ratingId") String ratingId) {
        HotelRatingModel hotelRatingModel = ratingService.getByRatingId(ratingId);

        ApiResponse apiResponse = ApiResponse.<HotelRatingModel>builder().message("sucess").statusCode(HttpStatus.OK.value()).data(hotelRatingModel).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
