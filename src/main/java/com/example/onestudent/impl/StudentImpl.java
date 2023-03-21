package com.example.onestudent.impl;

import com.example.onestudent.domain.Student;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

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
        if (student.getId() == null) {
            Student saveStudent = studentRepository.save(student);
            return saveStudent;
        } else {
            Optional<Student> optionalStudent = studentRepository.findById(student.getId());
            if (optionalStudent.isPresent()) {
                Student existingStudent = optionalStudent.get();
                existingStudent.setName(student.getName());
                existingStudent.setAge(student.getAge());
                Student updateStudent = studentRepository.save(existingStudent);
                return updateStudent;
            } else {
                throw new RuntimeException("数据中找不到学生id为" + student.getId() + "的学生，因此添加信息无需学生填写id");
            }
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }else {
            throw new RuntimeException("找不到id为"+id +"的学生");
        }
//        studentRepository.deleteById(id);
    }
}
