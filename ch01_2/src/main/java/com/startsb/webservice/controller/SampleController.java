package com.startsb.webservice.controller;


import com.startsb.webservice.domain.Sample;
import com.startsb.webservice.domain.Sample2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/sample")
    public Sample makeSample(){
        Sample vo = new Sample();
        vo.setVal1("v1");
        vo.setVal2("v2");
        vo.setVal3("v3");
        System.out.println(vo+" @");
        System.out.println(vo.toString());
        return vo;
    }

    @GetMapping("/sample2")
    public Sample2 makeSample2(){
        Sample2 vo = new Sample2();
        vo.setVal1("v1");
        vo.setVal2("v2");
        vo.setVal3("v3");
        System.out.println(vo +" @");
        System.out.println(vo.toString());
        return vo;
    }

}
