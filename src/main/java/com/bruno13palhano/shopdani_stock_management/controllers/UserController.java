package com.bruno13palhano.shopdani_stock_management.controllers;

import com.bruno13palhano.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/user/{email}")
    public User retrieveUser(@PathVariable String email) {
        return new User();
    }
}
