package com.example.jojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController {

    @GetMapping("/hello")
    public String hellocome(){
        return "hello world";
    }
}
