package com.learning.user.controller;

import com.learning.user.entity.User;
import com.learning.user.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
@Tag(name = "User API", description = "User API's to create and get all users")
public class UserController {

    UserServiceImpl userService;

    @Autowired
    UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/")
    @Operation(description = "User API to create new user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else {
            throw new RuntimeException("User not found with user id - " + id);
        }
    }
}
