package com.microservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Images {
    @Id

    private Long id;

    private String imageUrl;
    private String publicId;  // Unique identifier in Cloudinary

}
