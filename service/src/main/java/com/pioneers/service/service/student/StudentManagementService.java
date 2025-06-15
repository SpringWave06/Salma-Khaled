package com.pioneers.service.service.student;

import com.pioneers.service.model.dto.StudentResponse;
import com.pioneers.service.model.dto.StudentSignUpDto;

import java.util.List;
import java.util.Optional;

public interface StudentManagementService {

    List<StudentResponse> findAll();

    Optional<StudentResponse> findFirst();

    StudentResponse findByName(final String name);

    List<StudentResponse> findByAge(final int age);

    void deleteByNameAndAge(final String name, final int age);

    void deleteAll();

    StudentResponse increaseAgeByYear(final StudentSignUpDto studentSignUpDto);
}
