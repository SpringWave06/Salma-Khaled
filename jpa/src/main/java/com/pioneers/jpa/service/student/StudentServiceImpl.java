package com.pioneers.jpa.service.student;

import com.pioneers.jpa.model.dto.StudentDto;
import com.pioneers.jpa.model.entity.Student;
import com.pioneers.jpa.repositoty.student.StudentCustomRepository;
import com.pioneers.jpa.util.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return studentCustomRepository.findAllCustom()
                .stream()
                .map(StudentMapper::toStudentDto)
                .toList();
    }

    @Override
    public StudentDto findByEmail(String email) {
        Student foundStudent = studentCustomRepository.findByEmailCustom(email);

        return toStudentDto(foundStudent);
    }
}
