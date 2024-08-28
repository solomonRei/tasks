package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.University;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private University university;

    public UniversityService(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public University createUniversity(String name, String location, Student student) {
        university.setName(name);
        university.setLocation(location);
        university.setStudent(student);
        return university;
    }

}
