package com.microservice.rating.service;

import com.microservice.rating.entities.HotelRatingModel;

import java.util.List;

public interface RatingService {
    public void saveRating(HotelRatingModel hotelRatingModel);

    public List<HotelRatingModel>getAllHotelRating();

    public List<HotelRatingModel>getAllByUserId(String UserId);

    public  List<HotelRatingModel>getAllByHotelId(String hotelId);
}
