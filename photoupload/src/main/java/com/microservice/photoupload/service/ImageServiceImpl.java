package com.microservice.photoupload.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.microservice.photoupload.entity.ImageModel;
import com.microservice.photoupload.repo.ImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;
    private final Cloudinary cloudinary;

    public ImageServiceImpl(ImageRepo imageRepo, Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
        this.imageRepo = imageRepo;
    }

    @Override
    public ImageModel uploadImage(MultipartFile file) throws Exception {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String imageUrl = uploadResult.get("url").toString();
        String publicId = uploadResult.get("public_id").toString();

        // Save image details in DB
        ImageModel image = new ImageModel();
        image.setImageUrl(imageUrl);
        image.setPublicId(publicId);
        return imageRepo.save(image);
    }

    @Override
    public ImageModel getImage(Long id) {
        Optional<ImageModel> imageModel = imageRepo.findById(id);
        return imageModel.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        imageRepo.deleteById(id);
    }
}
