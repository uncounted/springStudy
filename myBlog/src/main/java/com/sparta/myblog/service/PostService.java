package com.sparta.myblog.service;

import com.sparta.myblog.models.Post;
import com.sparta.myblog.models.PostRepository;
import com.sparta.myblog.models.PostRequestDto;
import com.sparta.myblog.utils.PasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) throws PasswordException{
        Post post = postRepository.findById(id).orElseThrow(
        () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );

        try {
            checkPassword(requestDto, post);
            post.updatePost(requestDto);
        } catch(PasswordException e) {
            throw new PasswordException(e.getMessage());
        }
        return id;
    }

    @Transactional
    public Long deletePost(Long id, PostRequestDto requestDto) throws PasswordException{
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        try {
            checkPassword(requestDto, post);
            postRepository.deleteById(id);
        } catch(PasswordException e) {
            throw new PasswordException(e.getMessage());
        }
        return id;
    }

    private void checkPassword(PostRequestDto requestDto, Post post) throws PasswordException {
        if(!post.getPassword().equals(requestDto.getPassword())) {
            throw new PasswordException("비밀번호가 틀렸습니다.");
        }
    }
}
