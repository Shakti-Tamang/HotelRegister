package com.microservice.photoupload.controller;

import com.cloudinary.Cloudinary;
import com.microservice.photoupload.entity.ImageModel;
import com.microservice.photoupload.response.ApiResponse;
import com.microservice.photoupload.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:8001") // Allows cross-origin requests
@Tag(name = "Image Upload", description = "API for uploading images to Cloudinary")
public class CloudinaryController {

    private final ImageService imageService;
    private final Cloudinary cloudinary;

    public CloudinaryController(ImageService imageService, Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
        this.imageService = imageService;
    }
    @PostMapping(value = "/saveImage", consumes = "multipart/form-data")
    @Operation(
            summary = "Upload an image",
            description = "Uploads an image file and returns the uploaded image details."
    )
    public ResponseEntity<ApiResponse> saveAll(
            @RequestParam("imageUrl")
            @Parameter(
                    description = "Image file to upload",
                    required = true,
                    content = @Content(mediaType = "multipart/form-data",
                            schema = @Schema(type = "string", format = "binary")))
                    MultipartFile imageUrl
    ) throws Exception {

        System.out.println("Received file: " + imageUrl.getOriginalFilename());
        System.out.println("File size: " + imageUrl.getSize());

        if (imageUrl.isEmpty()) {
            System.out.println("File is empty");
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("image not found")
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }

        ImageModel imageModel = imageService.uploadImage(imageUrl);

        ApiResponse apiResponse = ApiResponse.<ImageModel>builder()
                .message("success")
                .statusCode(HttpStatus.OK.value())
                .data(imageModel)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}