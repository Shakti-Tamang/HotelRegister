package com.microservices.hotel.repo;

import com.microservices.hotel.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface HotelRepository extends JpaRepository<Hotel, String> {

}
