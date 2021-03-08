package com.spring.api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Student with id: " + id + " does not exists.");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student was not found!"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email already exists!");
            }
            student.setEmail(email);
        }
    }
}
