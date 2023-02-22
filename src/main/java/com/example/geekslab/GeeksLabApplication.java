package com.example.geekslab;

import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

 public class GeeksLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeeksLabApplication.class, args);
    }

}
