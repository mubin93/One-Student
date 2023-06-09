package com.example.onestudent;

import com.example.onestudent.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class OneStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneStudentApplication.class, args);
    }

}
