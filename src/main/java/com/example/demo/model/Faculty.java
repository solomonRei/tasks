package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Faculty {
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
        this.students = new ArrayList<>(students);
    }

    public void setFacultyForEveryStudent() {
        for (Student student : students) {
            student.setFaculty(this);
        }
    }

    public List<Student> findStudentsByName(String firstName, String lastName) {
        List<Student> matchingStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) &&
                student.getLastName().equals(lastName)) matchingStudents.add(student);
        }

        return matchingStudents;
    }

    public String toString() {
        return "Faculty [name=" + name + ", students=" + students + "]";
    }
}
