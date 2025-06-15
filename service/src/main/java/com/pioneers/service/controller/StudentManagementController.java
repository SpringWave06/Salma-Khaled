package com.pioneers.service.controller;

import com.pioneers.service.error.exception.AuthenticationException;
import com.pioneers.service.model.dto.StudentResponse;
import com.pioneers.service.model.dto.StudentSignUpDto;
import com.pioneers.service.service.student.StudentAuthenticationService;
import com.pioneers.service.service.student.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pioneers.service.error.model.Errors.STUDENT_NOT_REGISTERED;

@RestController
@RequestMapping("student/management")
public class StudentManagementController {

    private final StudentManagementService studentManagementService;
    private final StudentAuthenticationService studentAuthenticationService;

    @Autowired
    public StudentManagementController(
            StudentManagementService studentManagementService,
            StudentAuthenticationService studentAuthenticationService
    ) {
        this.studentManagementService = studentManagementService;
        this.studentAuthenticationService = studentAuthenticationService;
    }

    @GetMapping("findAll")
    public List<StudentResponse> findAllApi() {
        return studentManagementService.findAll();
    }

    @GetMapping("findFirst")
    public StudentResponse findFirstApi() {
        return studentManagementService.findFirst().orElse(null);
    }

    @GetMapping("findByName")
    public StudentResponse findByNameApi(@RequestParam String name, @RequestParam String id) {
        if (!studentAuthenticationService.isLoggedIn(id)) {
            throw new AuthenticationException(
                    STUDENT_NOT_REGISTERED.getMessage(),
                    STUDENT_NOT_REGISTERED.getDescription()
            );
        }

        return studentManagementService.findByName(name);
    }

    @GetMapping("findByAge")
    public ResponseEntity<List<StudentResponse>> findByAgeApi(@RequestParam int age, @RequestParam String id) {

        if (!studentAuthenticationService.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(studentManagementService.findByAge(age));
    }

    @DeleteMapping("deleteByNameAndAge")
    public ResponseEntity<String> deleteByNameAndAgeApi(
            @RequestParam String name,
            @RequestParam int age
    ) {
        studentManagementService.deleteByNameAndAge(name, age);
        return ResponseEntity.ok("Students with name '" + name + "' and age " + age + " were deleted");
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<String> deleteAllApi() {
        studentManagementService.deleteAll();
        return ResponseEntity.ok("All students deleted");
    }

    @PostMapping("increaseAge")
    public ResponseEntity<StudentResponse> increaseStudentAgeByOneApi(
            @RequestBody StudentSignUpDto studentSignUpDto,
            @RequestHeader String id
    ) {
        if (!studentAuthenticationService.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(studentManagementService.increaseAgeByYear(studentSignUpDto));
    }
}
