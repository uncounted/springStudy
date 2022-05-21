package com.sparta.week02homework.controller;

import com.sparta.week02homework.domain.Person;
import com.sparta.week02homework.domain.PersonRepository;
import com.sparta.week02homework.domain.PersonRequestDto;
import com.sparta.week02homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }
}
