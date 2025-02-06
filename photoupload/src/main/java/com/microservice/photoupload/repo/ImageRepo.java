package com.microservice.photoupload.repo;

import com.microservice.photoupload.entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel,Long> {

    //
    public ImageModel findByImageUrlAndOrderByIdAsc(String imageUrl,Long id);
}
