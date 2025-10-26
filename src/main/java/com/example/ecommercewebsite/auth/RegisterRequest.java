package com.example.ecommercewebsite.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @Email(message = "please provide a valid email.")
    String email;

    @Size(min = 8, max = 16, message = "password should be between 8 to 16 chars")
    String password;

    @Size(min = 1, max = 20, message = "please provide firstname")
    String firstName;

    @Size(min = 1, max = 20, message = "please provide lastname")
    String lastName;
}
