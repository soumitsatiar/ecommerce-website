package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.repositories.UserRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DemoController {

    private final UserRepo userRepo;

    public DemoController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

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

    @GetMapping("/me")
    public User me() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email).orElse(null);

        if (user != null) {
            user.setPassword(null);
        }

        return user;
    }

}
