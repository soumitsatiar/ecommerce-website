package com.example.ecommercewebsite.services;

import com.example.ecommercewebsite.dtos.UserDto;
import com.example.ecommercewebsite.models.Role;
import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.repositories.UserRepo;
import com.example.ecommercewebsite.utils.exceptions.EmailAlreadyExists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User signup(UserDto user) {

        Optional<User> oldUser = userRepo.findByEmail(user.email());
        if (oldUser.isPresent()) throw new EmailAlreadyExists("email already exists");

        User newUser = User.builder()
                .email(user.email())
                .password(user.password())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .role(Role.USER)
                .build();

        return userRepo.save(newUser);
    }

}
