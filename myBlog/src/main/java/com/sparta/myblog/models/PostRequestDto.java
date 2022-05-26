package com.sparta.myblog.models;

import lombok.Getter;


@Getter
public class PostRequestDto {
    private String author;
    private String password;
    private String title;
    private String contents;
}
