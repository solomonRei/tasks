package com.example.demo.api.requests;

import com.example.demo.model.Student;

import java.util.List;

public class FacultyRequest {
    private String name;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
