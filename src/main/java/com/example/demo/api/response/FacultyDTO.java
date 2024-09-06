package com.example.demo.api.response;

import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.example.demo.mappers.StudentMapper.toStudentUsualDTO;

public class FacultyDTO {
    @JsonProperty("faculty_name")
    private String name;
    @JsonProperty("faculty_students")
    private List<StudentUsualDTO> students;

    public String getName() {
        return name;
    }

    public List<StudentUsualDTO> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = toStudentUsualDTO(students);
    }
}
