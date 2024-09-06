package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private Faculty faculty;

    public FacultyService(Faculty faculty) {
        this.faculty = faculty;
    }

    public void updateFaculty(Faculty faculty, String name, List<Student> students) {
        faculty.setName(name);
        faculty.setStudents(students);
        faculty.setFacultyForEveryStudent();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Faculty setFaculty(String name, List<Student> students) {
        faculty.setName(name);
        faculty.setStudents(students);

        return faculty;
    }
}
