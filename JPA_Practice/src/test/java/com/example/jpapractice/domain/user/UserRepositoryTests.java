package com.example.jpapractice.domain.user;

import com.example.jpapractice.domain.user.User;
import com.example.jpapractice.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepo;

    @Test
    public void testBasic(){
        System.out.println(userRepo.count());
        userRepo.findAll().forEach(usr->{
            System.out.println(usr);
        });
    }

    @Test
    public void testIns(){
        User usr = new User();
        usr.setUserId("onemoon");
        userRepo.save(usr);
    }

    @Test
    public void testRead(){
        if(userRepo.exists(1l)){
            User usr = userRepo.findOne(1l);
            System.out.println(usr);
        }else
            System.out.println("No Data");
    }

    @Test
    public void testUpdate(){
        if(userRepo.exists(1l)){
            User usr = userRepo.findOne(1l);
            System.out.println(" orizinal : "+usr.getUserId());
            usr.setUserId("onemoon_upd");
            System.out.println(" updated : "+usr.getUserId());
            userRepo.save(usr);
        }else
            System.out.println("No Data");
    }

    @Test
    public void testDel(){

        System.out.println(" DELETE ");
        // 예외 처리 필요함( id 가 없는 경우 )
        if(userRepo.exists(1L))
            userRepo.delete(1L);
        else
            System.out.println("Fail : No data");
    }

    @Test
    public void testByUser_id(){
        userRepo.findUserByUserId("onemoon").forEach( user ->
            System.out.println(user)
        );
    }
}
