package com.pioneers.jpa.controller;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;
import com.pioneers.jpa.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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

    @PostMapping("createEsraa")
    public StudentDto createEsraa(@RequestBody StudentDto studentDto){
        return studentService.createEsraa(studentDto);
    }

    // TODO: Create an API to update Esraa by updating her age, degree
    @PutMapping("updateEsraa/{degree}/{age}")
    public StudentDto updateEsraa(@PathVariable Float degree, @PathVariable Integer Age){
        return studentService.updateEsraa(degree, Age);
    }


    // TODO: Create an API to delete Esraa from the DB
    @DeleteMapping("deleteEsraa")
    public void deleteEsraa(){
        studentService.deleteEsraa();
    }


    // TODO: Create API that accept age, enrollmentDate, namePattern and find all students with the accepted params
    @GetMapping("filter/{age}/{enrollmentDate}/{namePattern}")
    public List<StudentDto> filterStudent(@PathVariable Integer age,
                                      @PathVariable Date enrollmentDate,
                                      @PathVariable String namePattern) {
    return studentService.filterStudent(age, enrollmentDate, namePattern);
}

    // TODO: Don't forget to handle the errors in the
}
