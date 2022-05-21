package com.sparta.week02homework.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PersonRequestDto {
    private final String name;
    private final String job;
    private final int age;
    private final String address;
}
