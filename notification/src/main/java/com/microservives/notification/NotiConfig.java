package com.microservives.notification;

import com.microservives.notification.config.FirebaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotiConfig {
    public static void main(String[] args) {
        try {
            FirebaseConfig.initializeFireBase();
            SpringApplication.run(NotiConfig.class, args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
