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
@CrossOrigin("*") // Allows cross-origin requests
@Tag(name = "Image Upload", description = "API for uploading images to Cloudinary")
public class CloudinaryController {

    private final ImageService imageService;
    private final Cloudinary cloudinary;

    public CloudinaryController(ImageService imageService, Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
        this.imageService = imageService;
    }

    @PostMapping("/saveImage")
    @Operation(
            summary = "Upload an image",
            description = "Uploads an image file and returns the uploaded image details.",
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Image uploaded successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ImageModel.class))),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid file upload"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public ResponseEntity<ApiResponse> saveAll(
            @RequestParam("imageUrl")
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Image file to upload", required = true,
                    content = @Content(mediaType = "multipart/form-data",
                            schema = @Schema(type = "string", format = "binary")))
                    MultipartFile imageUrl
    ) throws Exception {
        ImageModel imageModel = imageService.uploadImage(imageUrl);

        ApiResponse apiResponse = ApiResponse.<ImageModel>builder()
                .message("success")
                .statusCode(HttpStatus.OK.value())
                .data(imageModel)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}