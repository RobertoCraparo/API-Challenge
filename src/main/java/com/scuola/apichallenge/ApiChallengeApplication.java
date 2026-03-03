package com.scuola.apichallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Inizializza il contesto Spring e avvia il web server integrato.
@SpringBootApplication
public class ApiChallengeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiChallengeApplication.class, args);
    }
}