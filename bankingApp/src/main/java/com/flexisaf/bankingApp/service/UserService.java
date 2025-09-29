package com.flexisaf.bankingApp.service;

import org.springframework.stereotype.Service;
import com.flexisaf.bankingApp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 public void createUser(){
       userRepository.save(user).orElseThrow(()-> new RuntimeException("User not created due to invalid data"));
 }
}
