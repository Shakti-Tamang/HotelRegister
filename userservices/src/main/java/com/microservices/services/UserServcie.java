package com.microservices.services;

import com.microservices.entity.HotelUser;

import java.util.List;

public interface UserServcie {
    public void saveUser(HotelUser user);
    public List<HotelUser>getAll();
}
