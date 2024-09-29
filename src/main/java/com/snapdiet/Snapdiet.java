package com.snapdiet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Snapdiet {
    public static void main(String[] args) {
        SpringApplication.run(Snapdiet.class, args);
    }
}

