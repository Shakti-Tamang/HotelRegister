package com.microservices.asyncthread.controller;

import com.microservices.asyncthread.response.ApiResponse;
import com.microservices.asyncthread.services.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8016")
public class ThreadControllers {
    private final Logger logger;
    //ctrl+shit+t to create test


    private final ThreadService threadService;



    public ThreadControllers(ThreadService threadService){
        this.threadService = threadService;
        this.logger= LoggerFactory.getLogger(ThreadControllers.class);
    }

    @PostMapping("/Thread1")
    public ResponseEntity<ApiResponse>saveThread(){
        ApiResponse apiResponse=ApiResponse.builder().message("thread started").statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/Thread1Get")

//    Main Thread (http-nio-8069-exec-4): This is the thread that is handling the HTTP request in your
//    Spring application. When you make a request to the /Thread1Get endpoint, the request is first
//    handled by this thread, and that's why you see "thraad response" + "\t" + Thread.currentThread().getName()
//    printing out the main thread name (http-nio-8069-exec-4).
//
//    Async Thread (ShaktiThread-1): This thread is the one executing the asyncMethodTest() method.
//    Because the method is annotated with @Async, Spring runs it in a different thread, which is
//    taken from a thread pool (Spring defaults to a SimpleAsyncTaskExecutor unless you configure a
//            custom thread pool). In your case, the thread is named ShaktiThread-1, which suggests it
//    is from a thread pool where threads are named with a prefix (e.g., ShaktiThread-), and this is
//    the first thread in the pool.

//    -main threadname : thraad response	http-nio-8069-exec-4
//   thread crteated by thread pool:   Aync method service	ShaktiThread-1
    public String getSate(){
        System.out.println("thraad response"+"\t"+Thread.currentThread().getName());
      threadService.asyncMethodTest();
        return HttpStatus.OK.toString();
    }

}
