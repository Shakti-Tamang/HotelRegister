package com.microservice.photoupload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images")
public class ImageModel {

    @Id


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String imageUrl;
    private String publicId;  // Unique identifier in Cloudinary

}
