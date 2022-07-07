package com.ddehaty.simpletask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("local")
@SpringBootApplication
public class SimpleTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTaskApplication.class, args);
    }

}
