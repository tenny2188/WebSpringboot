package com.webproject.webSpring.web;

import com.webproject.webSpring.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponceDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public PostsMainResponceDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
