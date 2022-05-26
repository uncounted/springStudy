package com.sparta.myblog.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.myblog.models.Post;
import com.sparta.myblog.models.PostRepository;
import com.sparta.myblog.models.PostRequestDto;
import com.sparta.myblog.service.PostService;
import com.sparta.myblog.utils.PasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostRestController {
    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/api/posts")
    public String getPosts(Model model){
        List<Post> post = postRepository.findAllByOrderByModifiedAtDesc();
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) throws Exception {
        Long returnId = 0L;

        try {
            returnId = postService.updatePost(id, requestDto);
        } catch(PasswordException e){
            System.out.println(e.getMessage());
        }

        return returnId;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Long returnId = 0L;

        try {
            returnId = postService.deletePost(id, requestDto);
        } catch(PasswordException e){
            System.out.println(e.getMessage());
        }

        return returnId;
    }
}
