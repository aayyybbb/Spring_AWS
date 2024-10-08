package com.jojoldu.book.sbws.domain.posts;

import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndReadPost(){
        String title = "title";
        String content = "content";

        postsRepository.save(Posts
                .builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        List<Posts> posts = postsRepository.findAll();

        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void insertBaseTimeEntity(){
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("title").author("author").content("content").build());
        List<Posts> posts = postsRepository.findAll();
        Posts post = posts.get(0);
        System.err.println(">>>>>>>>>>>>> createdAt = " + post.getCreatedDate() + "//" + "modifiedAt = " + post.getModifiedDate());
        assertThat(post.getCreatedDate()).isAfter(now);
            assertThat(post.getModifiedDate()).isAfter(now);
    }
}
