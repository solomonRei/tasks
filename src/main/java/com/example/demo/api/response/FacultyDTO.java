package com.example.demo.api.response;

import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyDTO {
    @JsonProperty("faculty_name")
    private String name;
    @JsonProperty("faculty_students")
    private List<StudentUsualDTO> students;

    public FacultyDTO(Faculty faculty) {
        this.name = faculty.getName();
        setStudents(faculty.getStudents());
        setFacultyForEveryStudent();
    }

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
        this.students = students.stream()
                .map(StudentUsualDTO::new)
                .collect(Collectors.toList());
    }

    public void setFacultyForEveryStudent() {
        for (StudentUsualDTO student : students) {
            student.setFaculty(this);
        }
    }
}
