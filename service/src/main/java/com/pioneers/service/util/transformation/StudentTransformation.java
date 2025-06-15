package com.pioneers.service.util.transformation;

import com.pioneers.service.model.dto.StudentResponse;
import com.pioneers.service.model.dto.StudentSignUpDto;
import com.pioneers.service.model.entity.Student;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import static com.pioneers.service.util.Utils.generateRandomUuid;

/**
 * Performs all student transformation.
 *
 * @author Abdelaziz Said
 */
@UtilityClass
public class StudentTransformation {

    /**
     * Transforms from StudentSignUpDto to Student Entity.
     *
     * @param studentSignUpDto Includes information to register student.
     * @return The student entity.
     */
    public static Student toRegisteredStudent(@NonNull final StudentSignUpDto studentSignUpDto) {
        return Student.builder()
                .id(generateRandomUuid())
                .name(studentSignUpDto.getName())
                .email(studentSignUpDto.getEmail())
                .age(studentSignUpDto.getAge())
                .address(studentSignUpDto.getAddress())
                .password(studentSignUpDto.getPassword())
                .isLoggedIn(false)
                .build();
    }

    public static StudentResponse toStudentResponse(@NonNull final Student student) {
        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .address(student.getAddress())
                .build();
    }

    public static StudentResponse toStudentResponse(@NonNull final StudentSignUpDto studentSignUpDto) {
        return StudentResponse.builder()
                .name(studentSignUpDto.getName())
                .email(studentSignUpDto.getEmail())
                .age(studentSignUpDto.getAge())
                .address(studentSignUpDto.getAddress())
                .build();
    }
}
