package com.pioneers.jpa.service.student;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;
import com.pioneers.jpa.repositoty.student.StudentCustomRepository;
import com.pioneers.jpa.util.mapper.StudentMapper;

import jakarta.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import static com.pioneers.jpa.util.mapper.StudentMapper.toListStudentDtos;
import static com.pioneers.jpa.util.mapper.StudentMapper.toStudentDto;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentCustomRepository studentCustomRepository;

    @Autowired
    public StudentServiceImpl(StudentCustomRepository studentCustomRepository) {
        this.studentCustomRepository = studentCustomRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentCustomRepository.findAllCustom();
        if (students.isEmpty()) {
            throw new NoResultException("No students found.");
        }
        return students.stream()
                .map(StudentMapper::toStudentDto)
                .toList();
    }

    @Override
    public StudentDto findByEmail(String email) {
        try {
            Student foundStudent = studentCustomRepository.findByEmailCustom(email);

        return toStudentDto(foundStudent);
        } catch (Exception e) {
            throw new RuntimeException("No student found with email: " + email);
        }
    }

    @Override
    public StudentDto createEsraa(StudentDto studentDto){
        try {
            Student newStudent = studentCustomRepository.createEsraa(studentDto);
            return toStudentDto(newStudent);
        } catch (Error e) {
            throw new RuntimeException("Failed to create Student" + e);
        }
    }

    @Override
    public StudentDto updateEsraa(Float degree, Integer Age){
        try {
            Student updateStudent = studentCustomRepository.updateEsraa(degree, Age);
            return toStudentDto(updateStudent);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update" + e);
        }
    }

    @Override
    public void deleteEsraa(){
        try {
            studentCustomRepository.deleteEsraa();
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete" + e);
        }
    }

    @Override
    public List<StudentDto> filterStudent(Integer age, Date enrollmentDate, String namePattern){
        try {
            List<Student> filteredStudents = studentCustomRepository.filterStudent(age, enrollmentDate, namePattern);
            return toListStudentDtos(filteredStudents);
        } catch (Exception e) {
            throw new RuntimeException("Failed to filter");
        }
    }
}
