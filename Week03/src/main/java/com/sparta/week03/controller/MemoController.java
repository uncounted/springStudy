package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    private final MemoRepository memoRepository;

    @GetMapping("/api/memos")
    public List<Memo> getMemo(){
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(
                (LocalDateTime.of(LocalDate.now().minusDays(1),
                        LocalTime.of(0,0,0))),
                (LocalDateTime.of(LocalDate.now(),
                        LocalTime.of(23, 59, 59)))
        );
    }

    @PostMapping("/api/memos")
    public Memo create(@RequestBody MemoRequestDto memoRequestDto){
        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto){
        return memoService.update(id, memoRequestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long delete(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
}
