package com.microservices.repo;

import com.microservices.entity.HotelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<HotelUser,String> {
    public HotelUser  findByEmail(String email);

    public List<HotelUser> findByEmailOrderByUserIdAsc(String email);

    @Query(name = "HotelUser.findByAboutM")
    public List<HotelUser>findByAboutMe(@Param("aboutMe") String aboutMe);
}
