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
@CrossOrigin(origins = "http://localhost:8001")  // Allow requests from Swagger UI
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
//
//    In Spring Boot, a starter dependency is a pre-packaged set of dependencies that
//    simplify the configuration and setup of an application.
//
//🔹 Why Use Starters?
//            ✅ Reduces the need for manual dependency management
//✅ Automatically includes required libraries
//✅ Provides sensible default configurations
//
//✔ This will automatically include Spring Core, Spring Context, and other necessary
//    dependencies.
//
//
//    ✅ Spring Context manages the lifecycle of beans.
//✅ IoC (Inversion of Control) makes objects loosely coupled.
//            ✅ Spring Container creates and manages beans automati cally.
//✅ Spring Beans are objects managed by the container.
//            ✅ Spring Bean Scopes define the lifecycle of beans.
//Scope	Description
//    singleton	(Default) One instance per container
//    prototype	New instance for each request
//    request	New instance per HTTP request (Web)
//    session	New instance per HTTP session (Web)
//    globalSession	New instance per global session (Web)
//

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

    @DeleteMapping("/deleteByUserId/{userId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("userId") String userId) {
        userServcie.deleteById(userId);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("User and Ratings successfully deleted")
                .statusCode(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PatchMapping("/updateUser/{userId}")
    public ResponseEntity<ApiResponse>editUser(@PathVariable("userId") String userId,@RequestBody HotelUser user){

        userServcie.updateUser(userId,user);

        ApiResponse apiResponse=ApiResponse.builder().message("successfully updated").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


}
