package com.microservices.controller;

import com.microservices.entity.HotelUser;
import com.microservices.response.ApiResponse;
import com.microservices.services.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8002")  // Allow requests from Swagger UI
public class UserController {


//    post api for users:

//    When you hit an API in Postman, it sends a request to the specified endpoint, which
//    the server processes and returns the response.


//    ResponseEntity is a wrapper for the entire HTTP response, including the status code, headers, and body, enabling full control over the response.
//    It allows you to set custom HTTP status codes (e.g., 200 OK, 400 Bad Request), response headers, and data in the body.
//    By using ResponseEntity, you can handle error scenarios gracefully and return structured responses with appropriate metadata.
//    It provides flexibility in RESTful API responses, ensuring that clients receive informative and contextually relevant data.

    @Autowired
    UserServcie userServcie;


    @PostMapping("/saveUser")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody HotelUser user) {
        userServcie.saveUser(user);
        ApiResponse apiResponse = ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<ApiResponse> getUserAll() {
        List<HotelUser> list = userServcie.getAll();

        ApiResponse apiResponse = ApiResponse.<HotelUser>builder().message("message").statusCode(HttpStatus.OK.value()).list(list).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getUser/{userId}")

    public ResponseEntity<ApiResponse>getUsersById(@PathVariable("userId") String userId){

            HotelUser hotelUser = userServcie.getByUserId(userId);

            ApiResponse apiResponse = ApiResponse.<HotelUser>builder().message("success").statusCode(HttpStatus.OK.value()).data(hotelUser).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }


}
