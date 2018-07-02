package com.example.rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hellocom(){
        return "hello world";
    }

    @GetMapping("/hello2")
    public String hellocom2(){
        return "hello world 2 ";
    }
}
