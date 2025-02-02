package com.microservice.rating.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
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

    @Transient
    Hotel hotel=new Hotel();

}
