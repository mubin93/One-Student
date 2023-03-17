package com.example.onestudent.service;

import com.example.onestudent.bean.StudentBean;
import com.example.onestudent.domain.Student;
import com.example.onestudent.repository.StudentRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    //    Integer save(@NotNull StudentBean studentDto);
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        if (student.getId() == null) {
            return studentRepository.save(student);
        } else {
            Optional<Student> optionalStudent = studentRepository.findById(student.getId());
            if (optionalStudent.isPresent()) {
                Student existingStudent = optionalStudent.get();
                existingStudent.setName(student.getName());
                existingStudent.setAge(student.getAge());
                return studentRepository.save(existingStudent);
            } else {
                throw new RuntimeException("Student not found with id" + student.getId());
            }
        }
    }

}
