package com.pioneers.rest.controller;

import com.pioneers.rest.model.dto.GeneralResponse;
import com.pioneers.rest.model.dto.StudentLoginDto;
import com.pioneers.rest.model.dto.StudentSignupDto;
import com.pioneers.rest.model.dto.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@ResponseBody
@RequestMapping("student")
public class StudentController {

    private final Set<StudentSignupDto> students;

    public StudentController() {
        students = new LinkedHashSet<>();
    }

    @PostMapping("signup")
    public ResponseEntity<GeneralResponse> signupApi(@RequestBody StudentSignupDto studentSignupDto) {
        if (studentSignupDto.getEmail().contains("@") &&
                !studentSignupDto.getName().isEmpty() &&
                studentSignupDto.getName().length() >= 2 &&
                studentSignupDto.getName().length() <= 30
        ) {
            students.add(studentSignupDto);
            GeneralResponse generalResponse
                    = new GeneralResponse("200", "signedUpSuccess", "This student has been registered");
            return ResponseEntity.ok(generalResponse);
        } else {
            System.err.println("Cannot sign up this student");
            GeneralResponse generalResponse
                    = new GeneralResponse("1000", "signedUpFail", "Failed to sign up the student");
            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        }

    }

    // TODO: Prevent hit all APIs if the students is not logged in
    @PostMapping("login")
    public void loginApi(@RequestBody StudentLoginDto studentLoginDto) {
        students.stream()
                .filter(student -> student.getEmail().equalsIgnoreCase(studentLoginDto.getEmail())
                        && student.getPassword().equals(studentLoginDto.getPassword()))
                .findFirst()
                .ifPresentOrElse(student -> System.out.println("Student " + student.getName() + " login successful"),
                        () -> System.out.println("Student cannot login successful"));

        /*if (optionalStudentSignupDto.isPresent()) {
            System.out.println("Student " + optionalStudentSignupDto.get().getName() + " is Login successful");
        } else {
            System.out.println("Student cannot login successful");
        }*/
    }

    @GetMapping("findAll")
    public List<StudentResponse> findAllApi() {
        return students.stream()
                .map(studentSignupDto -> new StudentResponse(studentSignupDto.getName(),
                        studentSignupDto.getEmail(), studentSignupDto.getAge(), studentSignupDto.getAddress()))
                .toList();
    }

    // TODO: Solve the exception occurred in this API when there is no object in the set
    @GetMapping("findFirst")
    public StudentResponse findFirstApi() {
        return students.stream()
                .map(studentSignupDto -> new StudentResponse(studentSignupDto.getName(),
                        studentSignupDto.getEmail(), studentSignupDto.getAge(), studentSignupDto.getAddress()))
                .findFirst().get();
    }

    @DeleteMapping("deleteAll")
    public void deleteAllApi() {
        students.clear();
    }

    // TODO: Create an API to create Logout API
    //   Create an API to modify his information,
    //   Create an API to find a student by his name from your data source
    //   Create an API to find all students by in the same age from your data source
    //   Create an API to delete all students with the same name and the same age from your data source

    @GetMapping("increaseStudentAge")
    public StudentResponse increaseStudentAgeByOneApi(@RequestBody final StudentSignupDto studentSignupDto) {
        int newAge = increaseAgeByOneYear(studentSignupDto.getAge());
        return new StudentResponse(studentSignupDto.getName(), studentSignupDto.getEmail(), newAge, studentSignupDto.getAddress());
    }

    public int increaseAgeByOneYear(final int age) {
        return age + 1;
    }
}
