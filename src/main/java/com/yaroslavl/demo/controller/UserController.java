package com.yaroslavl.demo.controller;

import com.yaroslavl.demo.model.UserRequest;
import com.yaroslavl.demo.service.UserService;
import com.yaroslavl.demo.store.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
// создание пользователя
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest user) {

        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}