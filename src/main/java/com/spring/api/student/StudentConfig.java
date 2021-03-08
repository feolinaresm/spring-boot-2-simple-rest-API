package com.spring.api.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args-> {
            Student miguel = new Student("Miguel", LocalDate.of(2002, 5, 15), "feolinatresm@gmail.com");
            Student angel = new Student("Angel", LocalDate.of(2002, 5, 15), "gravedigger15052001@gmail.com");

            studentRepository.saveAll(List.of(miguel, angel));
        };
    };
}
