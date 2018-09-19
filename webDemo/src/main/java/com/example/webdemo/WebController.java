package com.example.webdemo;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class WebController {
    @GetMapping(value = "/")
    public String main(){
        return "main";
    }
//    @GetMapping(value = "/hbtest")
//    public String hbtest() throws IOException {
//        Handlebars handlebars = new Handlebars();
//
//        Template template = handlebars.compileInline("Hello {{this}}!");
//
//        System.out.println(template.apply("Handlebars.java"));
//        return template.apply("Handlebars.java");
//    }

}
