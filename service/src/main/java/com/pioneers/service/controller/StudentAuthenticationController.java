package com.pioneers.service.controller;

import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentSignUpDto;
import com.pioneers.service.service.student.StudentAuthenticationService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student/authentication")
public class StudentAuthenticationController {

    private final StudentAuthenticationService studentAuthenticationService;

    @Autowired
    public StudentAuthenticationController(StudentAuthenticationService studentAuthenticationService) {
        this.studentAuthenticationService = studentAuthenticationService;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signUpApi(@Valid @NonNull @RequestBody StudentSignUpDto studentSignUpDto) {
        studentAuthenticationService.signUp(studentSignUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student registered successfully");
    }

    @PostMapping("login")
    public ResponseEntity<String> loginApi(@RequestBody StudentLoginDto studentLoginDto) {
        studentAuthenticationService.login(studentLoginDto);

        return ResponseEntity.ok("Login successful");
    }

    @DeleteMapping("logout/{id}")
    public ResponseEntity<String> logoutApi(@PathVariable String id) {
        studentAuthenticationService.logout(id);
        return ResponseEntity.ok(" Student is logout successful");
    }
}
