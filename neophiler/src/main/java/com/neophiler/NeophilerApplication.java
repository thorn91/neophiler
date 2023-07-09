package com.neophiler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NeophilerApplication {
    @Value("${spring.datasource.url}")
    private  String test;

    public static void main(String[] args) {
        SpringApplication.run(NeophilerApplication.class, args);
    }
}
