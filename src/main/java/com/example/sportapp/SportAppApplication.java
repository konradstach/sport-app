package com.example.sportapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SportAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SportAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ok");
    }
}

