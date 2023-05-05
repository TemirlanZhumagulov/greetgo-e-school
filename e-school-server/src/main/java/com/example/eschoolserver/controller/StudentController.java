package com.example.eschoolserver.controller;

import com.example.eschoolserver.model.Response;
import com.example.eschoolserver.model.ResponseBuilder;
import com.example.eschoolserver.model.Student;
import com.example.eschoolserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getStudents() {
        return ResponseEntity.ok(
                new ResponseBuilder()
                        .withTimeStamp(now())
                        .withData(Map.of("students", studentService.getAllStudents()))
                        .withMessage("Students retrieved")
                        .withStatus(OK)
                        .withStatusCode(OK.value())
                        .build()
                );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                new ResponseBuilder()
                        .withTimeStamp(now())
                        .withData(Map.of("student", studentService.getStudentById(id)))
                        .withMessage("Student retrieved")
                        .withStatus(OK)
                        .withStatusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok(
                new ResponseBuilder()
                        .withTimeStamp(now())
                        .withData(Map.of("student", student))
                        .withMessage("Student added")
                        .withStatus(CREATED)
                        .withStatusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(
                new ResponseBuilder()
                        .withTimeStamp(now())
                        .withData(Map.of("deleted", studentService.getStudentById(id) == null))
                        .withMessage("Student deleted")
                        .withStatus(OK)
                        .withStatusCode(OK.value())
                        .build()
        );
    }

    // other methods for handling PUT, PATCH, etc. requests
}
