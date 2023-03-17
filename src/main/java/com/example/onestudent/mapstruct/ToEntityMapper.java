package com.example.onestudent.mapstruct;

import org.mapstruct.MappingTarget;

public interface ToEntityMapper<Entity,StudentBean> {
    Entity toEntity(StudentBean studentBean);
    Entity updateEntity(@MappingTarget Entity targrt, StudentBean from);
}
