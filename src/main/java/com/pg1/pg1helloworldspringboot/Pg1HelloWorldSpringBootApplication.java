package com.pg1.pg1helloworldspringboot;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Objects;


@SpringBootApplication
public class Pg1HelloWorldSpringBootApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Pg1HelloWorldSpringBootApplication.class.getClassLoader();

        InputStream serviceAccount = classLoader.getResourceAsStream("serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);


        SpringApplication.run(Pg1HelloWorldSpringBootApplication.class, args);
    }

}
