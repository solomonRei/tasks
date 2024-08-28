package com.example.demo.api.requests;

import com.example.demo.model.Student;

public class UniversityRequest {
    private String name;
    private String location;
    private Student student;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
