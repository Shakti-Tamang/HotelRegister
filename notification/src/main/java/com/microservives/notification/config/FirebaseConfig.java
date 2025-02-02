package com.microservives.notification.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    public static void initializeFireBase() throws IOException {
        FileInputStream serviceAccount =new FileInputStream("C:\\Users\\Shakti\\Desktop\\HotelRatingService\\notification\\src\\main\\resources\\firebase.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

    }
}