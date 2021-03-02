package com.spring.api.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Para poder usar nuestras clases en un aplicativo Rest, estos deben ser JavaBeans, usando @Component, pero existe una más especifica:
@Service //Solo se usa más por semantica
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Miguel", 19, LocalDate.of(2001, 05, 15), "feolinaresm@gmail.com"),
                new Student(2L, "Angel", 19, LocalDate.of(2001, 05, 15), "feolinaresm1@gmail.com"),
                new Student(3L, "Stiven", 21, LocalDate.of(2003, 05, 15), "feolinaresm2@gmail.com")
        );
    }
}
