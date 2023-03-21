package com.example.onestudent.repository;

import com.example.onestudent.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{

    List<Student> findByNameContaining(String name);

    List<Student> findByAge(Integer age);

}
