package com.microservices.hotel.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel {

    @Id
    private String id;

    private String name;

    private String location;

    private String about;
    // In hotelservices module, Hotel.java

}


