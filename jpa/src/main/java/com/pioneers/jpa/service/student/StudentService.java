package com.pioneers.jpa.service.student;

import com.pioneers.jpa.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findByEmail(String email);
}
