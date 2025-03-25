package com.github.Fitt25.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    private final SoftwareEngineerService softwareEngineerService;

    public Application(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World Spring Boot!";
    }
}

