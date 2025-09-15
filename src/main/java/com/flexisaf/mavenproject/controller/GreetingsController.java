package com.flexisaf.mavenproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingsController {

    @GetMapping
   public String greetUser(){
        return "Hello, welcome to my project";
    }
    
}
