package com.flexisaf.bankingApp.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import com.flexisaf.bankingApp.repository.UserRepository;
import com.flexisaf.bankingApp.entity.UserEntity;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 public UserEntity createUser(UserEntity user){
        if(userRepository.findByEmail(user.getEmail()) == null){
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
            
        }
       else{
        throw new IllegalArgumentException("email address already exist");
       }
    }
}
