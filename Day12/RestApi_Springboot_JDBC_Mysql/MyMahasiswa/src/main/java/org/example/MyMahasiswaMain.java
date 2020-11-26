package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Scanning base package
@SpringBootApplication(scanBasePackages = {"org.example"})
public class MyMahasiswaMain {
    public static void main(String[] args) {
        SpringApplication.run(MyMahasiswaMain.class, args);
    }
}
