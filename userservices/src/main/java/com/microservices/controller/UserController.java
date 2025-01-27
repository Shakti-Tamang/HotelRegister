package com.microservices.controller;

import com.microservices.entity.HotelUser;
import com.microservices.response.ApiResponse;
import com.microservices.services.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServcie userServcie;


    @PostMapping("/saveUser ")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody HotelUser user){
        userServcie.saveUser(user);
        ApiResponse apiResponse=ApiResponse.builder().message("success").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
