package com.example.onestudent.impl;

import com.example.onestudent.bean.StudentBean;
import com.example.onestudent.domain.Student;
import com.example.onestudent.mapstruct.StudentMapper;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import com.sun.istack.NotNull;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;

public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudentyName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public List<Student> getStudentByAge(Integer age) {
        return studentRepository.findByAge(age);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
