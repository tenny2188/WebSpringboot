package com.webproject.webSpring.service;

import com.webproject.webSpring.domain.posts.PostRepository;
import com.webproject.webSpring.web.PostsMainResponceDto;
import com.webproject.webSpring.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {
    private PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponceDto> findAllDesc() {
        return postRepository.findAllDesc()
                .map(PostsMainResponceDto::new)
                .collect(Collectors.toList());
    }

}
