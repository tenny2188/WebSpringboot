package com.webproject.webSpring.service;

import com.webproject.webSpring.WebSpringApplication;
import com.webproject.webSpring.domain.posts.PostRepository;
import com.webproject.webSpring.domain.posts.Posts;
import com.webproject.webSpring.web.PostsSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application.yml")
//@ContextConfiguration(classes = WebSpringApplication.class)
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanup () {
        postRepository.deleteAll();
    }

    @Test
    public void Saved () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("tenny210@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}