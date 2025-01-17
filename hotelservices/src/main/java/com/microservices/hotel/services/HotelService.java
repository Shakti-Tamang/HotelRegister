package com.microservices.hotel.services;

import com.microservices.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    public void saveHotel(Hotel hotel);

    public List<Hotel> getAllHotel();

    public Hotel getHotelById(String id);
}
