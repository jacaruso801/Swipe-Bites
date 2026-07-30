package com.joseph.swipebites.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joseph.swipebites.dto.AuthResponse;
import com.joseph.swipebites.dto.LoginRequest;
import com.joseph.swipebites.model.User;
import com.joseph.swipebites.repository.UserRepository;
import com.joseph.swipebites.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}
