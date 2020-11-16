package com.cciric.show_of_hands.controller;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.models.User;
import com.cciric.show_of_hands.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody UserEntity entity){
        return userService.createUser(entity);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }
}
