package com.spring.api.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity//Usando esta anotación estaré mapeando la clase para representar un objeto de la base de datos (JPA)
@Table //Mapeamos la clase de tal manera que representará una tabla
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
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

    public Student() {

    }
}