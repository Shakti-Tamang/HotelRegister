package com.microservices.hotel.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
//@FeignClient(name = "hotelModel")
public class Hotel {

    @Id
    private String id;

    private String name;

    private String location;

    private String about;

}


