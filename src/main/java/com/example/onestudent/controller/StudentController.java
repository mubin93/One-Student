package com.example.onestudent.controller;

import com.example.onestudent.domain.Student;
import com.example.onestudent.repository.StudentRepository;
import com.example.onestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("list")
    public List<Student> getStudent() {
//        return studentRepository.findAll();
        return studentService.getAllStudents();
    }

    @GetMapping("/list/{id}")
    public Student getUserById(@PathVariable Long id) {
//        return studentRepository.findById(id).orElse(null);
        return studentService.getStudentById(id);
    }

    @GetMapping("/list/name/{name}")
    public List<Student> getUserByName(@PathVariable String name) {
//        return studentRepository.findByName(name);
        return studentService.getStudentyName(name);
    }

    @GetMapping("/list/age/{age}")
    public List<Student> getUserByAge(@PathVariable Integer age) {
//        return studentRepository.findByAgeGreaterThan(age);
        return studentService.getStudentByAge(age);
    }

//    @PostMapping("save")
//    public ResponseEntity<Integer> save(@Validated (StudentBean.Save.class) @RequestBody StudentBean studentBean){
//        Integer id=studentService.save(studentBean);
//        return ResponseEntity.ok(id);
//    }

    @ExceptionHandler(Exception.class)
    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {

        try {
            Student saveStudent=studentService.saveStudent(student);
            return ResponseEntity.ok(saveStudent);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

//        try {
////            Student saveStudent = studentService.save(student);
////            return ResponseEntity.ok(saveStudent);
//
//            if (student.getId() == null) {
//                Student saveStudent = studentRepository.save(student);
//                return ResponseEntity.ok(saveStudent);
//            } else {
//                Optional<Student> optionalStudent = studentRepository.findById(student.getId());
//                if (optionalStudent.isPresent()) {
//                    Student existingStudent = optionalStudent.get();
//                    existingStudent.setName(student.getName());
//                    existingStudent.setAge(student.getAge());
//                    Student student1 = studentRepository.save(existingStudent);
//                    return ResponseEntity.ok(student1);
//                } else {
//                    throw new RuntimeException("数据中找不到学生id为" + student.getId() + "的学生，因此添加信息无需学生填写id");
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
////            String errorMessage = "An error occurred while processing your request: " + e.getMessage();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        try {
            Optional<Student> optionalStudent= studentRepository.findById(id);
            if (optionalStudent.isPresent()){
                Student student=optionalStudent.get();
                studentRepository.delete(student);
                return ResponseEntity.ok("id为"+id +"，姓名为"+student.getName()+"的学生删除成功");
            }else {
                throw new RuntimeException("找不到id为"+id +"的学生");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
