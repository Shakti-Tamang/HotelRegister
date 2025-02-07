package com.microservices.services;

import com.microservices.entity.Hotel;
import com.microservices.entity.HotelRatingModel;
import com.microservices.entity.HotelUser;
import com.microservices.feignclient.RatingFiegnService;
import com.microservices.repo.UserRepo;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private RatingFiegnService ratingFiegnService;

    private final Logger logger;

    public UserServiceImpl() {
        this.logger = LoggerFactory.getLogger(UserServiceImpl.class);
    }

    @Override
    public void saveUser(HotelUser user) {

        user.setUserId(UUID.randomUUID().toString());
        userRepo.save(user);

    }


    @Transactional
    //services intercommunication using rest template
    @Override
    public List<HotelUser> getAll() {
        List<HotelUser> users = userRepo.findAll();
        List<HotelRatingModel> list = null;
        boolean found = false;
        for (HotelUser li : users) {


            try {
                list = ratingFiegnService.getAllByUserId(li.getUserId());
                if (!list.isEmpty()) {
                    li.setList(list);
                    found = true;
                } else {

                    li.setList(new ArrayList<>());
                }
            } catch (FeignException.NotFound e) {
                // Handle 404 error gracefully
                logger.error("Hotel ratings not found for userId: " + li.getUserId());
            }


        }

        return users;
    }

    @Override
    public HotelUser getByUserId(String id) {
        Optional<HotelUser> hotelUser = userRepo.findById(id);

        List<HotelRatingModel> list = null;
        try {
            list = ratingFiegnService.getAllByUserId(id);
        } catch (FeignException.NotFound e) {
            // Handle 404 error gracefully
            logger.error("Hotel ratings not found for userId: " + id);
        }

        HotelUser hotel = hotelUser.orElse(null);
        hotel.setList(list);
        return hotel;
    }

    @Override
    public void deleteById(String id) {
        ratingFiegnService.deleteRating(id);  //
        userRepo.deleteById(id);  //
    }

    @Override
    public void updateUser(String id, HotelUser user) {
        Optional<HotelUser> getUser = userRepo.findById(id);

        if (getUser.isPresent()) {
            HotelUser hotelUser = getUser.get();

            if (user.getAboutMe() != null) {
                hotelUser.setAboutMe(user.getAboutMe());
            }
            if (user.getEmail() != null) {
                hotelUser.setEmail(user.getEmail());
            }

            if (user.getPassword() != null) {
                hotelUser.setPassword(user.getPassword());
            }
            userRepo.save(hotelUser);
        }
    }
    @Override
    public List<HotelUser> getByEmailOrderByUserId(String email) {

        List<HotelUser> list = userRepo.findByEmailOrderByUserIdAsc(email);
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public List<HotelUser> getByAboutMe(String aboutMe) {

        List<HotelUser> list = userRepo.findByAboutMe(aboutMe);
        return list.isEmpty() ? new ArrayList<>() : list;
    }
}
