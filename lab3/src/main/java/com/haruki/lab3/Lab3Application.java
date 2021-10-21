package com.haruki.lab3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class Lab3Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }

}
