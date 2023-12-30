package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultUserService;
import com.bruno13palhano.model.User;
import com.bruno13palhano.shopdani_stock_management.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private DefaultUserService defaultUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.createToken(authentication);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        token
                )
                .body(token);
    }

    @PostMapping(path = "/authenticated")
    public ResponseEntity<Boolean> authenticated(@RequestBody String token) {
        return new ResponseEntity<>(jwtTokenProvider.validateToken(token.replace("\"", "")), HttpStatus.OK);
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
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        defaultUserService.insert(user);

        return new ResponseEntity<>(defaultUserService.getByUsername(user.getUsername()), HttpStatus.OK);
    }

    @GetMapping(path = "/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        User user = defaultUserService.getByUsername(username);
        user.setPassword("");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
