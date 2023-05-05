package com.example.eschoolserver.mapper;

import com.example.eschoolserver.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM students")
    List<Student> getAllStudents();

    @Select("SELECT * FROM students WHERE id=#{id}")
    Student getStudentById(Long id);

    @Insert("INSERT INTO students(name, age, sex, gpa, course, email) VALUES(#{name}, #{age}, #{sex}, #{gpa}, #{course}, #{email})")
    void addStudent(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteStudentById(Long id);
}

