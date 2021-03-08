package com.spring.api.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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

    @Transient //esta quiere decir que no es necesario crear una columna en la DB pues teniendo la fecha de nacimiento, haremos el calculo para retornarlo cuando sea necesario
    private Integer age;
    private LocalDate dateOfBirthday;
    private String email;

    public Student(Long id, String name, LocalDate dateOfBirthday, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }

    public Student(String name, LocalDate dateOfBirthday, String email) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }

    public Student() {

    }

    public Integer getAge() {
        return Period.between(dateOfBirthday, LocalDate.now()).getYears();
    }
}