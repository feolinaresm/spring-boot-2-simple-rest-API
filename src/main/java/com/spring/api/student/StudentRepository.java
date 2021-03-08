package com.spring.api.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Una vez que extendemos la clase, debemos pasarlo dos generics, el primer es T o el tipo de objeto y el segundo
//el tipo de dato del id del T con el que trabajaremos

@Repository //Definimos nuestra interfaz como tipo repository, es semantica asi como el Service
public interface StudentRepository extends JpaRepository<Student, Long> {

    //SELECT * FROM student WHERE email = ?;
    //@Query("SELECT s FROM Student s WHERE s.email = ?1") Podemos usar esta anotación para saber qué es lo que está sucediendo detrás pero no es necesaria
    Optional<Student> findByEmail(String email);
}
