package com.example.webdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping(value = "/")
    public String main(){

        return "main";
    }

    @GetMapping(value = "/this")
    public ModelAndView testThis(){
        ModelAndView mv = new ModelAndView("this");
        mv.addObject("body","wow");
        return mv;
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
