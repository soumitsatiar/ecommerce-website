package com.example.ecommercewebsite.auth;

import com.example.ecommercewebsite.models.Role;
import com.example.ecommercewebsite.models.User;
import com.example.ecommercewebsite.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public RegisterResponse register(RegisterRequest request, String role) {
        var user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role.equals("USER") ? Role.USER : Role.SELLER)
                .build();

        userRepo.save(user);
        return new RegisterResponse("%s created successfully!".formatted(role));
    }

    public String authenticate(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()
                )
        );

        var user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow();

        return jwtService.generateToken(user);
    }
}
