package com.example.jpapractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserControll {

    @GetMapping("/hello")
    public String check(){
        return "hello world";
    }

}
