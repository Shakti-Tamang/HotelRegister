package com.microservices.repo;

import com.microservices.entity.HotelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<HotelUser,String> {

    public HotelUser  findByEmail(String email);
}
