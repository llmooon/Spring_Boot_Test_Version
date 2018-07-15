package com.soma.tripper.web;

import com.soma.tripper.domain.posts.PostsRepository;
import com.soma.tripper.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postRepository.save(dto.toEntity());
    }
}
