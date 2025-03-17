package com.microservices.asyncthread.controller;

import com.microservices.asyncthread.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8016")
public class ThreadControllers {
    private final Logger logger;

    public ThreadControllers(){
        this.logger= LoggerFactory.getLogger(ThreadControllers.class);
    }

    @PostMapping("/Thread1")
    public ResponseEntity<ApiResponse>saveThread(){
        ApiResponse apiResponse=ApiResponse.builder().message("thread started").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
