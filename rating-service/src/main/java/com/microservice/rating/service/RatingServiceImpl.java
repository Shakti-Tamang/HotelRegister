package com.microservice.rating.service;

import com.microservice.rating.entities.HotelRatingModel;
import com.microservice.rating.repo.RatingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;
    private final Logger logger;

    public RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
        this.logger= LoggerFactory.getLogger(RatingServiceImpl.class);
    }

    @Override
    public void saveRating(HotelRatingModel hotelRatingModel) {
        ratingRepo.save(hotelRatingModel);
    }

    @Override
    public List<HotelRatingModel> getAllHotelRating() {

        List<HotelRatingModel>list=ratingRepo.findAll();
        return list.isEmpty()? new ArrayList<>():list;
    }

    @Override
    public List<HotelRatingModel> getAllByUserId(String UserId) {

        List<HotelRatingModel>list=ratingRepo.findByUserId(UserId);
        return list.isEmpty()?new ArrayList<>():list;
    }

    @Override
    public List<HotelRatingModel> getAllByHotelId(String hotelId) {

        List<HotelRatingModel>list=ratingRepo.findByHotelId(hotelId);
        return list.isEmpty()? new ArrayList<>():list;
    }

    @Override
    public void deleteUser(String id) {
        ratingRepo.deleteByUserId(id);
    }
}
