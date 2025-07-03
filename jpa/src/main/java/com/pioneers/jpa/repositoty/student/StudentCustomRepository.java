package com.pioneers.jpa.repositoty.student;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;

import java.sql.Date;
import java.util.List;

public interface StudentCustomRepository {

    List<Student> findAllCustom();

    Student findByEmailCustom(String email);

    Student createEsraa(StudentDto studentDto);

    Student updateEsraa(Float degree, Integer Age);

    void deleteEsraa();

    List<Student> filterStudent(Integer age, Date enrollmentDate, String namePattern);
}
