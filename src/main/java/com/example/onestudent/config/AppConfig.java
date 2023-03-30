package com.example.onestudent.config;

import com.example.onestudent.impl.StudentImpl;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.security.sasl.SaslServer;

@Configuration
@ConditionalOnClass(StudentImpl.class)
public class AppConfig {

    @Bean
    public StudentService studentService(StudentRepository studentRepository){
        return new StudentImpl();
    }
}
