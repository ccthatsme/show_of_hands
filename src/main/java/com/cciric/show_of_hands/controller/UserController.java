package com.cciric.show_of_hands.controller;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.models.User;
import com.cciric.show_of_hands.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody UserEntity entity){
        return userService.createUser(entity);
    }
}
