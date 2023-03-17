package com.example.onestudent.mapstruct;

import com.example.onestudent.bean.StudentBean;
import com.example.onestudent.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends ToEntityMapper<Student, StudentBean>{
}
