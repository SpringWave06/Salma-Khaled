package com.pioneers.functionalprogramming.registration.service.student;

import com.pioneers.functionalprogramming.registration.model.dto.StudentDto;
import com.pioneers.functionalprogramming.registration.model.entity.Student;
import com.pioneers.functionalprogramming.registration.repository.StudentRepository;
import com.pioneers.functionalprogramming.registration.service.FailureCallback;
import com.pioneers.functionalprogramming.registration.service.SuccessCallback;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void registerStudent(
            StudentDto studentDto,
            SuccessCallback<Student> successCallback,
            FailureCallback failureCallback
    ) {
        SuccessCallback<Student> onSuccess = getStudentSuccessCallback(studentDto, successCallback, failureCallback);

        studentRepository.findByEmail(studentDto.email(), onSuccess, failureCallback);
    }

    private SuccessCallback<Student> getStudentSuccessCallback(
            StudentDto studentDto,
            SuccessCallback<Student> successCallback,
            FailureCallback failureCallback
    ) {
        return user -> {
            Student newStudent = new Student(UUID.randomUUID().toString(), studentDto.username(), studentDto.email());

            studentRepository.save(newStudent, successCallback, failureCallback);
        };
    }
}
