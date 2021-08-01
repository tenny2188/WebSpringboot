package com.webproject.webSpring.service;

import com.webproject.webSpring.domain.posts.PostRepository;
import com.webproject.webSpring.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostsService {
    private PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }
}
