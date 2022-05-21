package com.sparta.week02homework.service;

import com.sparta.week02homework.domain.Person;
import com.sparta.week02homework.domain.PersonRepository;
import com.sparta.week02homework.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    public Long update(Long id, PersonRequestDto requestDto){
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}
