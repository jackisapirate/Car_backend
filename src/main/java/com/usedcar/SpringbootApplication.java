package com.usedcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        System.out.println("SpringBoot Start Up");

        SpringApplication.run(SpringbootApplication.class, args);
    }

}
