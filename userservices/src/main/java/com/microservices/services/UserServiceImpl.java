package com.microservices.services;

import com.microservices.entity.HotelRatingModel;
import com.microservices.entity.HotelUser;
import com.microservices.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    private final Logger logger;

    public UserServiceImpl(){
        this.logger= LoggerFactory.getLogger(UserServiceImpl.class);
    }

    @Override
    public void saveUser(HotelUser user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepo.save(user);
    }

    @Override
    public List<HotelUser> getAll() {
        List<HotelUser> users = userRepo.findAll();

        // Collect all userIds
        List<String> userIds = users.stream()
                .map(HotelUser::getUserId)
                .collect(Collectors.toList());

        // Make a single API call to fetch ratings for all users
        Map<String, List<HotelRatingModel>> userRatingsMap = restTemplate.postForObject(
                "http://localhost:8073/getAllHotelRating/",
                userIds,
                Map.class
        );

        // Assign ratings to users
        for (HotelUser user : users) {
            List<HotelRatingModel> ratings = userRatingsMap.getOrDefault(user.getUserId(), new ArrayList<>());
            user.setList(ratings);
        }

        return users;
    }

    @Override
    public HotelUser getByUserId(String id) {
        HotelUser hotelUser = userRepo.findById(id)
                .orElseThrow(() -> new ResolutionException("UserId not found: " + id));

        ArrayList<HotelRatingModel> forObject=restTemplate.getForObject("http://localhost:8073/getAllHotelRating/"+hotelUser.getUserId(),ArrayList.class);
        hotelUser.setList(forObject);

        logger.info("user dto",forObject);
        return hotelUser;
    }

}
