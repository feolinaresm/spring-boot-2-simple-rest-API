package com.spring.api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Para poder usar nuestras clases en un aplicativo Rest, estos deben ser JavaBeans, usando @Component, pero existe una más especifica:
@Service //Solo se usa más por semantica
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); //El objeto de tipo StudentRepository nos permite usar metodos para realizar llamado o modificación de la data en DB
    }
}
