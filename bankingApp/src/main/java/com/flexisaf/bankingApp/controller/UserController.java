package com.flexisaf.bankingApp.controller;

/*
 * This is the UserController class.
 * It will handle the creation of users. 
 */
import com.flexisaf.bankingApp.entity.UserEntity;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create-user")
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {
        if (user != null){
            userService.createUser(user);
        }
        return ResponseEntity.ok("User created successfully");
    }

}
