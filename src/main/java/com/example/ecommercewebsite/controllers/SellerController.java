package com.example.ecommercewebsite.controllers;

import com.example.ecommercewebsite.dtos.UserDto;
import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.services.SellerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody UserDto userDto) {
        return sellerService.signup(userDto);
    }

}
