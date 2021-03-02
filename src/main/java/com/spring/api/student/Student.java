package com.spring.api.student;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private LocalDate dateOfBirthday;
    private String email;

    public Student(Long id, String name, Integer age, LocalDate dateOfBirthday, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }

    public Student(String name, Integer age, LocalDate dateOfBirthday, String email) {
        this.name = name;
        this.age = age;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }
}