package com.example.webdemo.controller;

import com.example.webdemo.dto.EnumRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestType {

    // multipart/form-data 에서는 값이 들어가지 않는다.
    // 한번 확인해보자
    @PostMapping(value = "/request/enum",produces = {"application/json","multipart/form-data" } , consumes={"multipart/form-data" , "application/x-www-form-urlencoded"})
    public EnumRequestDto testenum(EnumRequestDto enumRequestDto){
        System.out.println(enumRequestDto.getSeason());
        System.out.println(enumRequestDto.getTest());
        System.out.println("@@");

        return enumRequestDto;
    }



    @PostMapping(value = "/request/json",produces = "application/json" , consumes = "application/json")
    public Map testJSon(@RequestBody Map<String,String> req){
        System.out.println(req);
        return req;
    }
}

