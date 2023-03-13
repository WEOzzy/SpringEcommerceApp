package com.ecommerce.controllers;

import com.ecommerce.models.User;
import com.ecommerce.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
// @CrossOrigin(origins = {comma separated list of urls}, allowCredentials = "true", exposedHeaders = "Authorization")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("Register endpoint hit");
        User newUser = new User(
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(newUser));
    }
}