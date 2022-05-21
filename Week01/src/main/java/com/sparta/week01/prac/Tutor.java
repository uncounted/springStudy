package com.sparta.week01.prac;

public class Tutor {
    // title, tutor, days 가 Course 라는 맥락 아래에서 의도가 분명히 드러나죠!
    private String name;
    private String bio;

    //기본생성자
    public Tutor(){

    }

    //생성자
    public Tutor(String name, String bio){
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}