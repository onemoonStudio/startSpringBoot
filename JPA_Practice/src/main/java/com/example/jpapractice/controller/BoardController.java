package com.example.jpapractice.controller;

import com.example.jpapractice.domain.board.Board;
import com.example.jpapractice.domain.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board/*")
public class BoardController {


    @Autowired
    BoardRepository boardRepo;

    @GetMapping("/get")
    private Iterable<Board> getBoard(){

        return boardRepo.findAll();

    }

    // Request 를 보낼 때 Content-Type : application/json 반드시 설정 해줘야 한다.
    @PostMapping(value = "/create" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<Map> check(
            @RequestBody Map<String,String> hello
    ){
        System.out.println(hello);
        System.out.println(new ResponseEntity<>(HttpStatus.CREATED));
        return new ResponseEntity<>(hello,HttpStatus.CREATED);

    }



}
