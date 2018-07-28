package com.example.jpapractice.domain.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTests {
    @Autowired
    BoardRepository BoardRepo;


    @Test
    public void testIns20(){
        for(int i=0;i<20;i++){
            Board board = new Board();
            board.setTitle("제목.."+i);
            board.setContents("내용..."+i);
            board.setWriter("User"+i);
            BoardRepo.save(board);
        }
    }

    @Test
    public void checkData(){
        System.out.println("Check Data!");

        BoardRepo.findAll().forEach(board->{
            System.out.println(board.toString());
        });
    }


    @Test
    public void testQueryTitle(){
        BoardRepo.findBoardByTitle("제목..1").forEach(board->{
            System.out.println(board);
        });
    }

    @Test
    public void testQueryLike(){
        // % + 키워드 + % 에 대한 처리를 합니다.
        BoardRepo.findByWriterContaining("User1").forEach(board->{
            System.out.println(board);
        });
    }


}
