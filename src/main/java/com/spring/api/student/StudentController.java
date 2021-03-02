package com.spring.api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Rest controller nos define una clase para servir endpoints
@RequestMapping(path = "api/v1/student") //Definimos el path en el cual estarán alojados nuestros endpoints
public class StudentController {

    private final StudentService studentService;

    @Autowired //Esto instancia las dependencias que tengamos, por nosotros
    public StudentController(StudentService studentService) {
        this.studentService = studentService; //Aqui estamos usando inyección de dependencias pues normalmente usariamos new StudentService;
    }

    @GetMapping //GetMapping nos permite definir un endpoint
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
