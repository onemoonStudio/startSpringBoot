package com.example.exhandler.controller;

import com.example.exhandler.exception.BadRequestException;
import com.example.exhandler.exception.BaseException;
import com.example.exhandler.exception.ConflictException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping({"" , "/"})
public class MainController {

    @GetMapping("/ex1")
    public void extest(){
        throw new BaseException(500,"Base Exception");
    }

    @GetMapping("/bad")
    public @ResponseBody void badreq(HttpServletResponse response){
        response.setStatus(BadRequestException.getCode());
        throw new BadRequestException("h");
    }

    @GetMapping("/conf")
    public @ResponseBody void confreq(){

        throw new ConflictException();
    }

    @GetMapping("/base")
    public @ResponseBody void baseEx(HttpServletResponse response){
        response.setStatus(400);
        throw new BaseException(400,"hello");
    }
}
