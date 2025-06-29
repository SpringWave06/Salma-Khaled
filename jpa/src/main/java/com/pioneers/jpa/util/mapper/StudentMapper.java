package com.pioneers.jpa.util.mapper;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class StudentMapper {

    public static StudentDto toStudentDto(Student student) {
        String[] names = student.getName().split(" ");
        String firstName = names[0];
        String secondName = names[1];

        return new StudentDto(firstName, secondName, student.getEmail(), student.getPhone(), student.getEnrollmentDate(), student.getDegree(), student.getGender());
    }
}
