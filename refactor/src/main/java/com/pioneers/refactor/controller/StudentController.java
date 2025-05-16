package com.pioneers.refactor.controller;

import com.pioneers.refactor.model.dto.StudentLoginDto;
import com.pioneers.refactor.model.dto.StudentResponse;
import com.pioneers.refactor.model.dto.StudentSignUpDto;
import com.pioneers.refactor.model.entity.Student;
import com.pioneers.refactor.util.StudentRepo;
import com.pioneers.refactor.util.StudentValidator;
import com.pioneers.refactor.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.pioneers.refactor.util.Utils.generateRandomUuid;
import static com.pioneers.refactor.util.transformation.StudentTransformation.toRegisteredStudent;

@RestController
@RequestMapping("student")
public class StudentController {

    @PostMapping("signup")
    public ResponseEntity<String> signUpApi(@RequestBody StudentSignUpDto studentSignUpDto) {
        if (!StudentValidator.isEmailValidated(studentSignUpDto) || !StudentValidator.isNameValidated(studentSignUpDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signup details");
        }

        Optional<Student> optionalRegisteredStudents = StudentRepo.getStudents().values().stream()
                .filter(registeredStudent -> registeredStudent.getEmail().equalsIgnoreCase(studentSignUpDto.getEmail()))
                .findFirst();

        if (optionalRegisteredStudents.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exists");
        }

        Student student = toRegisteredStudent(studentSignUpDto);

        StudentRepo.insertStudent(generateRandomUuid(), student);

        return ResponseEntity.status(HttpStatus.CREATED).body("Student registered successfully");
    }

    @PostMapping("login")
    public ResponseEntity<String> loginApi(@RequestBody StudentLoginDto studentLoginDto) {
        Optional<Student> optionalStudentEntity = StudentRepo.getStudents().values().stream()
                .filter(student -> StudentValidator.isEmailMatched(student.getEmail(), studentLoginDto.getEmail()) &&
                        StudentValidator.isPasswordMatched(student.getPassword(), studentLoginDto.getPassword()))
                .findFirst();

        if (optionalStudentEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        StudentRepo.login(optionalStudentEntity.get().getId());

        StudentRepo.insertStudent(optionalStudentEntity.get().getId() ,optionalStudentEntity.get());

        return ResponseEntity.ok("Login successful");

    }

    @DeleteMapping("logout/{id}")
    public ResponseEntity<String> logoutApi(@PathVariable String id) {
        if (!StudentRepo.isLoggedIn(id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Student is logged out.");
        }

        StudentRepo.logout(id);
        return ResponseEntity.ok(" Student is logout successful");
    }

    @GetMapping("findAll")
    public ResponseEntity<List<StudentResponse>> findAllApi(@RequestParam String id) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<StudentResponse> result = StudentRepo.getStudents().values().stream()
                .map(student -> new StudentResponse(student.getName(), student.getEmail(),
                        student.getAge(), student.getAddress()))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("findFirst")
    public ResponseEntity<StudentResponse> findFirstApi(@RequestParam String id) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return StudentRepo.getStudents().values().stream()
                .map(studentSignUpDto -> {
                    StudentResponse studentResponse = new StudentResponse(studentSignUpDto.getName(),
                            studentSignUpDto.getEmail(), studentSignUpDto.getAge(),
                            studentSignUpDto.getAddress());
                    return ResponseEntity.ok(studentResponse);
                })
                .findFirst()
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("findByName")
    public ResponseEntity<StudentResponse> findByNameApi(@RequestParam String name, @RequestParam String id) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return StudentRepo.getStudents().values().stream()
                .filter(student -> StudentValidator.isNameMatched(student.getName(), name))
                .findFirst()
                .map(firstStudent -> {
                    StudentResponse studentResponse = new StudentResponse(firstStudent.getName(),
                            firstStudent.getEmail(), firstStudent.getAge(), firstStudent.getAddress());

                    return ResponseEntity.ok(studentResponse);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("findByAge")
    public ResponseEntity<List<StudentResponse>> findByAgeApi(@RequestParam int age, @RequestParam String id) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<StudentResponse> responses = StudentRepo.getStudents().values().stream()
                .filter(student -> StudentValidator.isAgeMatched(student.getAge(), age))
                .map(student -> new StudentResponse(student.getName(), student.getEmail(),
                        student.getAge(), student.getAddress()))
                .toList();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("deleteByNameAndAge")
    public ResponseEntity<String> deleteByNameAndAgeApi(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String id
    ) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        boolean isRemoved = StudentRepo.getStudents().values()
                .removeIf(student -> StudentValidator.isNameMatched(student.getName(), name)
                && StudentValidator.isAgeMatched(student.getAge(), age));
        if (!isRemoved) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students are not found");

        }
        return ResponseEntity.ok("Students with name '" + name + "' and age " + age + " were deleted");
    }

    /*@PutMapping("update")
    public ResponseEntity<String> updateStudentInfoApi(
            @RequestBody UpdateStudentDto updatedStudentDto,
            @RequestParam String id
    ) {
        Optional<StudentEntity> optionalStudentEntity = registeredStudentEntities.stream()
                .filter(student -> isIdMatched(student.getId(), id))
                .findFirst();

        if (optionalStudentEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Student is not logged in.");
        }

        updateOrInsertStudent(updatedStudentDto);

    }

    private void updateOrInsertStudent(UpdateStudentDto studentDto) {
        StudentEntity redundantStudent = new StudentEntity();
        redundantStudent.setName(studentDto.getName());
        redundantStudent.setEmail(studentDto.getEmail());
        redundantStudent.setAge(studentDto.getAge());
        redundantStudent.setAddress(studentDto.getAddress());
        redundantStudent.setPassword(studentDto.getPassword());

        registeredStudentEntities.add(redundantStudent);
    }*/

    @DeleteMapping("deleteAll")
    public ResponseEntity<String> deleteAllApi() {
        StudentRepo.deleteAll();
        return ResponseEntity.ok("All students deleted");
    }

    @PostMapping("increaseAge")
    public ResponseEntity<StudentResponse> increaseStudentAgeByOneApi(
            @RequestBody StudentSignUpDto studentSignUpDto,
            @RequestHeader String id
    ) {
        if (!StudentRepo.isLoggedIn(id)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        int newAge = Utils.increaseAgeByOneYear(studentSignUpDto.getAge());
        StudentResponse response = new StudentResponse(studentSignUpDto.getName(), studentSignUpDto.getEmail(), newAge,
                studentSignUpDto.getAddress());
        return ResponseEntity.ok(response);
    }
}
