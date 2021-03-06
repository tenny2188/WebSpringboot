package com.webproject.webSpring.web;

import com.webproject.webSpring.domain.posts.PostRepository;
import com.webproject.webSpring.domain.posts.Posts;
import com.webproject.webSpring.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostRepository postRepository;
    private PostsService postsService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}

