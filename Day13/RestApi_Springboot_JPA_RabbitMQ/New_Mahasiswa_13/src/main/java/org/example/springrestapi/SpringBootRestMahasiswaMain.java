package org.example.springrestapi;

import org.example.springrestapi.rabbitmq.ReceiveMqRestAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestMahasiswaMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestMahasiswaMain.class, args);

    }
}
