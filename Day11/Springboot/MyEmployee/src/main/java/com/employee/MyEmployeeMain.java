package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Scanning directory/package base untuk SpringbootApp
@SpringBootApplication(scanBasePackages={"com.employee"})

public class MyEmployeeMain {
    public static void main(String[] args) {
        // Run Springboot App
        SpringApplication.run(MyEmployeeMain.class, args);
    }
}