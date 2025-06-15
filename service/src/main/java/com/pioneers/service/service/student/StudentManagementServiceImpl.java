package com.pioneers.service.service.student;

import com.pioneers.service.error.exception.StudentNotFoundException;
import com.pioneers.service.model.dto.StudentResponse;
import com.pioneers.service.model.dto.StudentSignUpDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.repository.student.StudentRepository;
import com.pioneers.service.util.transformation.StudentTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.pioneers.service.util.Utils.incrementAgeByYear;
import static com.pioneers.service.util.transformation.StudentTransformation.toStudentResponse;

@Slf4j
@Service
public class StudentManagementServiceImpl implements StudentManagementService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentManagementServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentTransformation::toStudentResponse)
                .toList();
    }

    @Override
    public Optional<StudentResponse> findFirst() {
        return studentRepository.findFirst()
                .map(StudentTransformation::toStudentResponse);
    }

    @Override
    public StudentResponse findByName(final String name) {
        Student student = studentRepository.findByName(name)
                .orElseThrow(() ->
                        new StudentNotFoundException("StudentNotFound", "Cannot find student with name " + name));
        return toStudentResponse(student);
    }

    @Override
    public List<StudentResponse> findByAge(final int age) {
        List<Student> students = studentRepository.findByAge(age);
        return students.stream()
                .map(StudentTransformation::toStudentResponse)
                .toList();
    }

    @Override
    public void deleteByNameAndAge(final String name, final int age) {
        studentRepository.deleteByAgeAndName(age, name);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public StudentResponse increaseAgeByYear(final StudentSignUpDto studentSignUpDto) {
        StudentSignUpDto newStudentSignUpDto = studentSignUpDto;
        newStudentSignUpDto.setAge(incrementAgeByYear(studentSignUpDto.getAge()));

        return toStudentResponse(newStudentSignUpDto);
    }
}
