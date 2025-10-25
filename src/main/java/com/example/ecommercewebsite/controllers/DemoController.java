package com.example.ecommercewebsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() { // user method
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String hello2() { // seller method
        return "Hello World";
    }

}
