package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.data.service.impl.DefaultUserService;
import com.bruno13palhano.model.User;
import com.bruno13palhano.shopdani_stock_management.JwtTokenProvider;
import com.bruno13palhano.shopdani_stock_management.UserResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin
public class UserController {
    private final String CODE = "CODE";

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
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest()
                    .header(HttpHeaders.AUTHORIZATION, "")
                    .header(CODE, UserResponseCode.INCORRECT_USERNAME_OR_PASSWORD.getCode())
                    .body("");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.createToken(authentication);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .header(CODE, UserResponseCode.OK.getCode())
                .body(token);
    }

    @PostMapping(path = "/authenticated")
    public ResponseEntity<Boolean> authenticated(@RequestBody String token) {
        return new ResponseEntity<>(jwtTokenProvider.validateToken(token.replace("\"", "")),
                HttpStatus.OK);
    }


    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody User user) {
        if (user == null || user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
                user.getTimestamp().isEmpty()) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.USER_NULL_OR_INVALID.getCode())
                    .body(null);
        }

        if (defaultUserService.usernameAlreadyExist(user.getUsername())) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.USERNAME_ALREADY_EXIST.getCode())
                    .body(null);
        }

        if (defaultUserService.emailAlreadyExist(user.getEmail())) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.EMAIL_ALREADY_EXIST.getCode())
                    .body(null);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        defaultUserService.insert(user);

        return ResponseEntity.ok()
                .header(CODE, UserResponseCode.OK.getCode())
                .body(defaultUserService.getByUsername(user.getUsername()));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        if (user == null || user.getUsername().isEmpty() || user.getEmail().isEmpty() ||
                user.getTimestamp().isEmpty()) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.USER_NULL_OR_INVALID.getCode())
                    .body(2);
        }

        User currentUser = defaultUserService.getById(user.getId());

        if (defaultUserService.usernameAlreadyExist(user.getUsername()) &&
                !Objects.equals(currentUser.getEmail(), defaultUserService.getByUsername(user.getUsername()).getEmail())) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.USERNAME_ALREADY_EXIST.getCode())
                    .body(3);
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setPhoto(user.getPhoto());
        currentUser.setTimestamp(user.getTimestamp());
        defaultUserService.update(currentUser);

        return ResponseEntity.ok()
                .header(CODE, UserResponseCode.OK.getCode())
                .body(0);
    }

    @PutMapping(path = "/update/password")
    public ResponseEntity<?> updatePassword(@RequestBody User user) {
        if (user == null || user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
                user.getTimestamp().isEmpty()) {
            return ResponseEntity.badRequest()
                    .header(CODE, UserResponseCode.USER_NULL_OR_INVALID.getCode())
                    .body(2);
        }

        User currentUser = defaultUserService.getByUsername(user.getUsername());
        currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        currentUser.setTimestamp(user.getTimestamp());
        defaultUserService.update(currentUser);

        return ResponseEntity.ok()
                .header(CODE, UserResponseCode.OK.getCode())
                .body(0);
    }

    @GetMapping(path = "/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        User user = defaultUserService.getByUsername(username);
        user.setPassword("");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
