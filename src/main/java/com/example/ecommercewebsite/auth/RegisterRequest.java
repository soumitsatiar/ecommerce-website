package com.example.ecommercewebsite.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String lastName;
    private String firstName;
    private String password;
}
