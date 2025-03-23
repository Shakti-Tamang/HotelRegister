package com.microservices.asyncthread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// it will create beans for async classes
//Which process the async tasks
//With the help of this annottaion its will helps other classes to create their bean whoch is involved in this process
//that is all class involved in Async Process
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableEurekaServer
@EnableDiscoveryClient
@EnableFeignClients
public class ThreadApp {

    public static void main(String[] args) {

        SpringApplication.run(ThreadApp.class, args);
    }
}

