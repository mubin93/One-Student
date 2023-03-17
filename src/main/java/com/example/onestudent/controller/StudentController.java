package com.example.onestudent.controller;

import com.example.onestudent.domain.Student;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("list")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public Student getUserById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/list/name/{name}")
    public List<Student> getUserByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/list/age/{age}")
    public List<Student> getUserByAge(@PathVariable Integer age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

//    @PostMapping("save")
//    public ResponseEntity<Integer> save(@Validated (StudentBean.Save.class) @RequestBody StudentBean studentBean){
//        Integer id=studentService.save(studentBean);
//        return ResponseEntity.ok(id);
//    }

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        try {
            Student saveStudent = studentService.save(student);
            return ResponseEntity.ok(saveStudent);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
