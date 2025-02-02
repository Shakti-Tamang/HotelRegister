package com.microservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.lang.annotation.Documented;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRatingModel {

//
//    ALTER TABLE table_name
//    MODIFY COLUMN column_name INT AUTO_INCREMENT PRIMARY KEY;

    @Id
    private String ratingId;

    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;


    private Hotel hotel;

}
