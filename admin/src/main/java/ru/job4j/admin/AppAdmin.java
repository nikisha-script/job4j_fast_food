package ru.job4j.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AppAdmin {

    @Value("${server.port}")
    private int port;

    @PostConstruct
    public void goToApp() {
        System.out.printf("go to:http://localhost:%d/api/v1/market%n", port);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppAdmin.class, args);
    }

}
