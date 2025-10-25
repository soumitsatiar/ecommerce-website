package com.example.ecommercewebsite.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('USER')")
    public String hello() { // user method
        return "Hello World";
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasRole('SELLER')")
    public String hello2() { // seller method
        return "Hello World";
    }

}
