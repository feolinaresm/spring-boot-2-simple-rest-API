package com.spring.api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Para poder usar nuestras clases en un aplicativo Rest, estos deben ser JavaBeans, usando @Component, pero existe una más especifica:
@Service //Se usa más por semantica e identifica la clase como un servicio, es decir, contiene la logica del programa
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); //El objeto de tipo StudentRepository nos permite usar metodos para realizar llamado o modificación de la data en DB
    }

    public void addNewStudent(Student student){
        //Queremos validar si existe ya un studiante con el mismo email que se está intentando registrar
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
        if (studentByEmail.isPresent()){ //El metodo present nos retorna un booleano afirmando que existe o no un usuario con el mismo email
            throw new IllegalStateException("Email is already in use"); //Si queremos podemos crear nuestra propia excepción
        }
        studentRepository.save(student);
    }
}
