package com.learn.springbootapplication.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontroller {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World To Spring Boot";
    }
}
