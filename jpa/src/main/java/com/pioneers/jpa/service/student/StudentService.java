package com.pioneers.jpa.service.student;

import com.pioneers.jpa.model.dto.StudentDto;

import java.sql.Date;
import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findByEmail(String email);

    StudentDto createEsraa(StudentDto studentDto);

    StudentDto updateEsraa(Float degree, Integer Age);

    void deleteEsraa();

    List<StudentDto> filterStudent(Integer age, Date enrollmentDate, String namePattern);
}
