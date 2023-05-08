package com.example.eschoolserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "studentID", updatable = false)
  private Long studentID;

  private String name;

    private int age;

    private boolean sex;

    private double gpa;

    private int course;

    private String email;

    public Student() {}

    public Student(String name, int age, boolean sex, double gpa, int course, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.gpa = gpa;
        this.course = course;
        this.email = email;
    }

  public Long getStudentID() {
    return studentID;
  }

  public void setStudentID(Long studentID) {
    this.studentID = studentID;
  }

  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
