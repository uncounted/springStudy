package com.sparta.week02homework;

import com.sparta.week02homework.controller.PersonController;
import com.sparta.week02homework.domain.Person;
import com.sparta.week02homework.domain.PersonRepository;
import com.sparta.week02homework.domain.PersonRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class Week02HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonController personConteroller) {
        return (args) -> {
            personRepository.save(new Person("최나나", "무직", 33, "보광동"));

            System.out.println("데이터 인쇄");
            List<Person> personList = personConteroller.getPersons();
            for (int i=0; i<personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getJob());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
            }
        };
    }

}
