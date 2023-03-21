package com.example.onestudent.config;

import com.example.onestudent.impl.StudentImpl;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.security.sasl.SaslServer;

@Configuration
@ComponentScan(basePackages ="com.example.onestudent" )
public class AppConfig {

    @Bean
    public StudentService studentService(StudentRepository studentRepository){
        return new StudentImpl();
    }
}
