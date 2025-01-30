package com.microservices.services;

import com.microservices.entity.HotelRatingModel;
import com.microservices.entity.HotelUser;
import com.microservices.feignclient.RatingFiegnService;
import com.microservices.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.module.ResolutionException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private RatingFiegnService ratingService;

    private final Logger logger;

    public UserServiceImpl() {
        this.logger = LoggerFactory.getLogger(UserServiceImpl.class);
    }

    @Override
    public void saveUser(HotelUser user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepo.save(user);
    }


    //services intercommunication using rest template
    @Override
    public List<HotelUser> getAll() {
        List<HotelUser> users = userRepo.findAll();
        // Collect all userIds
        List<String> userIds = users.stream()
                .map(HotelUser::getUserId)
                .collect(Collectors.toList());

        // Make a single API call to fetch ratings for all users
        Map<String, List<HotelRatingModel>> userRatingsMap = restTemplate.postForObject(
                "http://localhost:8076/ratings/getAllHotelRatingGet/",
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
        Optional<HotelUser> hotelUser = userRepo.findById(id);
        return hotelUser.orElse(null);
    }


}
