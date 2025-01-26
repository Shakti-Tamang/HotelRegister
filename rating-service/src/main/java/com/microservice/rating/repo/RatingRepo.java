package com.microservice.rating.repo;

import com.microservice.rating.entities.HotelRatingModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<HotelRatingModel,String> {

    public List<HotelRatingModel> findByUserId(String userId);

    public  List<HotelRatingModel>findByHotelId(String HotelId);

}
