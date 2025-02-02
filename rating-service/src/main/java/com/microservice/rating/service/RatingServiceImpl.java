package com.microservice.rating.service;

import com.microservice.rating.entities.Hotel;
import com.microservice.rating.entities.HotelRatingModel;
import com.microservice.rating.feing.FeingHotelService;
import com.microservice.rating.repo.RatingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;
    private final Logger logger;
    private final FeingHotelService feingHotelService;

    public RatingServiceImpl(RatingRepo ratingRepo, FeingHotelService feingHotelService) {
        this.ratingRepo = ratingRepo;
        this.logger = LoggerFactory.getLogger(RatingServiceImpl.class);
        this.feingHotelService = feingHotelService;
    }

    @Override
    public void saveRating(HotelRatingModel hotelRatingModel) {
        ratingRepo.save(hotelRatingModel);
    }

    @Override
    public List<HotelRatingModel> getAllHotelRating() {

        List<HotelRatingModel> list = ratingRepo.findAll();
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public List<HotelRatingModel> getAllByUserId(String UserId) {

        List<HotelRatingModel> list = ratingRepo.findByUserId(UserId);
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public List<HotelRatingModel> getAllByHotelId(String hotelId) {

        List<HotelRatingModel> list = ratingRepo.findByHotelId(hotelId);
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public void deleteUser(String id) {
        ratingRepo.deleteByUserId(id);
    }


    @Override
    public HotelRatingModel getByRatingId(String id) {
        Optional<HotelRatingModel> hotelRatingModel = ratingRepo.findById(id);

        if (hotelRatingModel.isEmpty()) {
            throw new NoSuchElementException("No HotelRatingModel found for id: " + id);
        }

        HotelRatingModel hotelRatingModel1 = hotelRatingModel.get();
        logger.info("Hotel ID to fetch: " + hotelRatingModel1.getHotelId());

        try {
            Hotel hotel = feingHotelService.getByHotelId(hotelRatingModel1.getHotelId());
            logger.info("Hotel Response: " + hotel);

            if (hotel == null) {
                throw new RuntimeException("Hotel data not found for id: " + hotelRatingModel1.getHotelId());
            }

            hotelRatingModel1.setHotel(hotel);
        } catch (Exception e) {
            logger.error("Error fetching hotel data: ", e);
        }

        return hotelRatingModel1;
    }

}
