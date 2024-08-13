package com.jojoldu.book.sbws.web.dto;

import com.jojoldu.book.sbws.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts posts) {
        System.err.println(posts.getModifiedDate());
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.modifiedDate = posts.getModifiedDate();
    }
}
