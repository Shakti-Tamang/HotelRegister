package com.microservice.rating.repo;

import com.microservice.rating.entities.HotelRatingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepo extends MongoRepository<HotelRatingModel,String> {

    public List<HotelRatingModel> findByUserId(String userId);

    public  List<HotelRatingModel>findByHotelId(String HotelId);

    void deleteByRatingId(String id);

}
