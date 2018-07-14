package com.soma.tripper.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    //given - 테스트 기반 구축
    public void loadPosts(){
        postRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("llmooon@naver.com")
                .build());

    //when - 테스트 하고자 하는 행위 선언
    List<Posts> postsList = postRepository.findAll();

    //then - 테스트 결과 검증
    Posts posts = postsList.get(0);
    assertThat(posts.getTitle(),is("테스트 게시글"));
    assertThat(posts.getContent(),is("테스트 본문"));
    }
}
