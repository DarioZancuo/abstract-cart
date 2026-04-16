package com.ecommerce.cart.service;

import com.ecommerce.cart.dto.request.LoginRequest;
import com.ecommerce.cart.dto.request.RegisterRequest;
import com.ecommerce.cart.dto.response.ApiResponse;
import com.ecommerce.cart.entity.jpa.User;
import com.ecommerce.cart.repository.UserRepository;
import com.ecommerce.cart.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyUserDetailService userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse<String> login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(userDetails);

        return ApiResponse.success("Login successful", token);
    }

    public ApiResponse<String> register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            return ApiResponse.error("Username already exists");
        }

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .build();

        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(userDetails);

        return ApiResponse.success("Registration successful", token);
    }
}