package com.sparta.myblog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Post(PostRequestDto requestDto){
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void updatePost(PostRequestDto requestDto){
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}
