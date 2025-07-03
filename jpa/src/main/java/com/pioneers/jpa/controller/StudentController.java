package com.pioneers.jpa.controller;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("findAll")
    public List<StudentDto> findAllApi() {
        return studentService.findAll();
    }

    @GetMapping("findByEmail/{email}")
    public StudentDto findByEmailApi(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }

    // TODO: Create an API to save student with name Esraa into the DB

    // TODO: Create an API to update Esraa by updating her age, degree

    // TODO: Create an API to delete Esraa from the DB

    // TODO: Create API that accept age, enrollmentDate, namePattern and find all students with the accepted params
    
    // TODO: Don't forget to handle the errors in the
}
