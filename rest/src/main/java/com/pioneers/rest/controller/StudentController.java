package com.pioneers.rest.controller;

import com.pioneers.rest.model.dto.StudentRequest;
import com.pioneers.rest.model.dto.StudentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    // TODO: Create Signup, Login, Logout API and register students into a data source
    //   Create an API to modify his information,
    //   Create an API to fetch all students from your data source
    //   Create an API to find the first student from your data source
    //   Create an API to find a student by his name from your data source
    //   Create an API to find all students by in the same age from your data source
    //   Create an API to delete all students with the same name and the same age from your data source
    //   Create an API to delete all students from your data source

    @GetMapping("increaseStudentAge")
    public StudentResponse increaseStudentAgeByOneApi(@RequestBody final StudentRequest studentRequest) {
        int newAge = increaseAgeByOneYear(studentRequest.getAge());
        return new StudentResponse(studentRequest.getName(), newAge, studentRequest.getAddress());
    }

    public int increaseAgeByOneYear(final int age) {
        return age + 1;
    }
}
