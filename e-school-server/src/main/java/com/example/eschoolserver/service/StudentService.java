package com.example.eschoolserver.service;

import com.example.eschoolserver.model.Student;
import com.example.eschoolserver.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }
    public Student getStudentById(Long id){
        return studentMapper.getStudentById(id);
    }
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    public void deleteStudentById(Long id) {
        studentMapper.deleteStudentById(id);
    }
}


