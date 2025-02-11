package com.microservice.photoupload.service;

import com.microservice.photoupload.entity.ImageModel;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public ImageModel uploadImage(MultipartFile file) throws Exception;

    public ImageModel getImage(Long id);

    public void deleteById(Long id);

}
