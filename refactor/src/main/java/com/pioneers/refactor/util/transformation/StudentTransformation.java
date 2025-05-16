package com.pioneers.refactor.util.transformation;

import com.pioneers.refactor.model.dto.StudentSignUpDto;
import com.pioneers.refactor.model.entity.Student;

import static com.pioneers.refactor.util.Utils.generateRandomUuid;

/**
 * Performs all student transformation
 *
 * @author Abdelaziz Said
 */
public class StudentTransformation {

    private StudentTransformation() {
        throw new IllegalStateException("StudentTransformation is a Utility class");
    }

    public static Student toRegisteredStudent(StudentSignUpDto studentSignUpDto) {
        return new Student(generateRandomUuid(), studentSignUpDto.getName(),
                studentSignUpDto.getEmail(), studentSignUpDto.getAge(), studentSignUpDto.getAddress(),
                studentSignUpDto.getPassword(), false);
    }
}
