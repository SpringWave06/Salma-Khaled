package com.pioneers.service.service.student;

import com.pioneers.service.error.exception.AuthenticationException;
import com.pioneers.service.error.model.Errors;
import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentSignUpDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.repository.student.StudentRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pioneers.service.util.StudentValidator.isEmailValidated;
import static com.pioneers.service.util.StudentValidator.isNameValidated;
import static com.pioneers.service.util.transformation.StudentTransformation.toRegisteredStudent;

@Slf4j
@Service
public class StudentAuthenticationServiceImpl implements StudentAuthenticationService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentAuthenticationServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean isLoggedIn(@NonNull final String id) {
        return studentRepository.isLoggedIn(id);
    }

    @Override
    public void signUp(@NonNull final StudentSignUpDto studentSignUpDto) {
        final String methodName = "signUp";

        Optional<Student> optionalRegisteredStudents = studentRepository.findStudentByEmail(studentSignUpDto.getEmail());

        if (optionalRegisteredStudents.isPresent()) {
            log.error("Student already Registered with this email: {}", studentSignUpDto.getEmail());
            Errors registeredError = Errors.STUDENT_REGISTERED;
            throw new AuthenticationException(registeredError.getMessage(), registeredError.getDescription());
        }

        Student student = toRegisteredStudent(studentSignUpDto);

        studentRepository.insertStudent(student.getId(), student);

        Object[] args = new Object[]{methodName, studentSignUpDto.getEmail(), studentSignUpDto.getPassword()};
        log.debug("{} / Successfully inserted student into the runtime db with id: [{}] and name: [{}]", args);
    }

    @Override
    public void login(@NonNull final StudentLoginDto studentLoginDto) {
        Optional<Student> optionalStudentEntity =
                studentRepository.findStudentByCredentials(studentLoginDto.getEmail(), studentLoginDto.getPassword());

        if (optionalStudentEntity.isEmpty()) {
            log.error("Student not found.");
            Errors loginError = Errors.LOGIN_ERROR;
            throw new AuthenticationException(loginError.getMessage(), loginError.getDescription());
        }

        final Student student = optionalStudentEntity.get();
        studentRepository.login(student.getId());
        studentRepository.insertStudent(student.getId(), student);
    }

    @Override
    public void logout(String id) {
        if (!studentRepository.isLoggedIn(id)) {
            log.error("Student is not logged in");
            throw new AuthenticationException(Errors.LOGOUT_ERROR.getMessage(), Errors.LOGOUT_ERROR.getDescription());
        }

        studentRepository.logout(id);
    }
}
