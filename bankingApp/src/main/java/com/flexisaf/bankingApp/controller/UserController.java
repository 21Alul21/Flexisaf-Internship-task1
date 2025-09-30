/*
 * This is the UserController class.
 * It will handle the creation of users. 
 */

package com.flexisaf.bankingApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flexisaf.bankingApp.entity.UserEntity;
import com.flexisaf.bankingApp.service.UserService;



@RestController
@RequestMapping("api/v1/")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create-user")
    public ResponseEntity<Object> createUser(@RequestBody UserEntity user) {
        if (user != null){
            userService.createUser(user);
        }
        Map<String, String> responseHm = new HashMap<>();
        responseHm.put("message","User created successfully");
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(responseHm);
    }

}
