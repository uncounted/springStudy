package com.sparta.myblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

//Long 을 먼저 쓰면 왜 Controller에서 에러가 나는지? - 그렇게 인터페이스에 정의돼있다
public interface PostRepository extends JpaRepository<Post, Long> {
}
