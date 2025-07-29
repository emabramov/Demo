package com.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewsSpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NewsSpringApplication.class, args);
    }
}