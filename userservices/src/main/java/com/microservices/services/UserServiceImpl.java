package com.microservices.services;

import com.microservices.entity.HotelUser;
import com.microservices.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    UserRepo userRepo;

    @Override
    public void saveUser(HotelUser user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepo.save(user);
    }
}
