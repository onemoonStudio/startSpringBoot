package com.example.boot5.controller;

import com.example.boot5.Test;
import com.example.boot5.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/sample1")
    public void sample1(Model model) {
        model.addAttribute("Greeting", "Hello world and Spring Boot");
        model.addAttribute("Test", "안녕하세요");
    }

    @GetMapping("/sample2")
    public void sample2(Model model) {
        MemberVO mem = new MemberVO(123, "u00", "1234", "홍길동"
                , new Timestamp(System.currentTimeMillis()));

        model.addAttribute("member", mem);
    }

    @GetMapping("/sample3")
    public void sample3(Model model) {
        List<MemberVO> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new MemberVO(123, "u0" + i, "p0" + i, "홍길동" + i
                    , new Timestamp(System.currentTimeMillis())));
        }

        model.addAttribute("list", list);
    }

}
