package com.microservices.hotel.services;

import com.microservices.hotel.entites.Hotel;
import com.microservices.hotel.repo.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final Logger logger;

    public HotelServiceImpl(HotelRepository hotelRepository) {

        this.hotelRepository = hotelRepository;
        logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    }

    @Override
    public void saveHotel(Hotel hotel) {

        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {

        List<Hotel> list = hotelRepository.findAll();
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public Hotel getHotelById(String id) {

        Optional<Hotel> oneHotel = hotelRepository.findById(id);
        return oneHotel.orElse(null);
    }
}
