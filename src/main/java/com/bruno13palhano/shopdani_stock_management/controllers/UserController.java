package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultUserService;
import com.bruno13palhano.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DefaultUserService defaultUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("Login successfully...", HttpStatus.OK);
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody User user) {
        if (user == null || user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
                user.getTimestamp().isEmpty()) {
            return new ResponseEntity<>("User is null or invalid", HttpStatus.BAD_REQUEST);
        }

        if (defaultUserService.usernameAlreadyExist(user.getUsername())) {
            return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
        }

        if (defaultUserService.emailAlreadyExist(user.getEmail())) {
            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        defaultUserService.insert(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
