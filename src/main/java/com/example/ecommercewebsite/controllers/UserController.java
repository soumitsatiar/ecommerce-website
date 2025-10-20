package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.dtos.UserDto;
import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

}
