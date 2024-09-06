package com.example.demo.service;

import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final University university;

    public UniversityService(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public Faculty getFaculty(String name) {
        return university.getFacultyByName(name);
    }

    public List<Faculty> getFaculties() {
        return university.getFaculties();
    }

    public University createUniversity(String name, String location, List<Faculty> faculties) {
        university.setName(name);
        university.setLocation(location);
        university.setFaculties(faculties);

        return university;
    }

    public List<Student> findStudentsByName(String firstName, String lastName) {
        return university.findStudentsByName(firstName, lastName);
    }
}
