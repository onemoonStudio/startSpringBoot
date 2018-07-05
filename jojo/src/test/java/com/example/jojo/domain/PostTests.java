package com.example.jojo.domain;

import com.example.jojo.domain.posts.Posts;
import com.example.jojo.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTests {

    @Autowired
    PostsRepository PostsRepo;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        PostsRepo.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        PostsRepo.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = PostsRepo.findAll();

        //then
        Posts posts = postsList.get(0);

        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }


}
