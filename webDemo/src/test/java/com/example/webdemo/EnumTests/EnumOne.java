package com.example.webdemo.EnumTests;

import com.example.webdemo.domain.constant.Season;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumOne {
    @Test
    public void simpleEnumTest(){
        System.out.println(Season.FALL);
    }
}
