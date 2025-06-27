package com.pioneers.functionalprogramming.registration.controller;

import com.pioneers.functionalprogramming.registration.model.dto.StudentDto;
import com.pioneers.functionalprogramming.registration.model.entity.Student;
import com.pioneers.functionalprogramming.registration.service.FailureCallback;
import com.pioneers.functionalprogramming.registration.service.SuccessCallback;
import com.pioneers.functionalprogramming.registration.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicReference;


@RestController
@RequestMapping("student")
public class RegistrationController {

    private static final AtomicReference<Object> response = new AtomicReference<>();

    private final StudentService studentService;

    @Autowired
    public RegistrationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("register")
    public Object registerApi(@RequestBody StudentDto studentDto) {
        studentService.registerStudent(studentDto, getSuccessResponse(), getFailureResponse());
        return response.get();
    }

    private SuccessCallback<Student> getSuccessResponse() {
        return student -> {
            System.out.println("Sending email using Sendgrid to " + student.email() + " with OTP");
            System.out.println("Once Validated the email by OTP");
            System.out.println("Successfully registered student into our system");
            response.set(ResponseEntity.ok(student));
        };
    }

    private FailureCallback getFailureResponse() {
        return message -> {
            System.out.println("Failed to register student into our system");
            response.set(ResponseEntity.badRequest().build());
        };
    }
}
