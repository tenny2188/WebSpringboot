package com.webproject.webSpring.domain.posts;


import com.webproject.webSpring.WebSpringApplication;
import org.junit.After;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.yml")
@ContextConfiguration(classes = WebSpringApplication.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    
    @BeforeEach
    public void cleanupfirst() {postRepository.deleteAll();}
    @After
    public void cleanup() {postRepository.deleteAll();}

    /*
    @Test
    public void call_Post() {
        //given
        postRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("Test Body 바디")
                .author("tenny210@gmail.com")
                .build());
        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("Test Body 바디"));
    }
    */
    @Test
    public void BaseTimeEntityADD(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("Test Body 바디")
                .author("tenny210@gmail.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertTrue(posts.getCreatedDate().isAfter(now));
        Assertions.assertTrue(posts.getModifiedDate().isAfter(now));
    }

}
