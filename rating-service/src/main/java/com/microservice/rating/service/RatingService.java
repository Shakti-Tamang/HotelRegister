package com.microservice.rating.service;

import com.microservice.rating.entities.HotelRatingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RatingService {
    public void saveRating(HotelRatingModel hotelRatingModel);

    public List<HotelRatingModel>getAllHotelRating();



    List<HotelRatingModel> getAllByUserId(String userId);

    public  List<HotelRatingModel>getAllByHotelId(String hotelId);
}
