package ru.job4j.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class AppDish {

    public static void main(String[] args) {
        SpringApplication.run(AppDish.class, args);
    }

}
