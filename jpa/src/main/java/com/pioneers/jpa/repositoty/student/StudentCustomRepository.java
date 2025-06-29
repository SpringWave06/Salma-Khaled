package com.pioneers.jpa.repositoty.student;

import com.pioneers.jpa.model.entity.Student;

import java.util.List;

public interface StudentCustomRepository {

    List<Student> findAllCustom();

    Student findByEmailCustom(String email);
}
