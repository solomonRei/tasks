package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//TODO: add Faculty class, refresh DTOs, and update the service +
// Create Faculty Service for getting facalty by name +
// Create Faculty Controller for getting faculty by name using @PathVariable +
// create method for Update faculty information by facultyName POST query, @RequestBody FacultyRequest +
// Update University Model to have a list of faculties +
// faculty has to have a name and a list of students +
// create 2 different endpoints for getting students information:
//  The first one is for admin: It should return the whole information abput the student +
//  The second one is for students: It should return only the student's name and the faculty name +
// THEORY:
// Spring beans - types of beans, how to create them, how to inject them
// what is the @Qualifier annotation and how to use it
// what is the @Primary annotation and how to use it
// Where can I use @Autowired annotation
// What is the difference between @Component, @Service, @Repository, @Controller
// How to configure the Beans in the Spring Boot application (3 ways)
// -----
// Spring beans - an instance of a class managed by the Spring container
// The @Qualifier annotation in Spring is used to resolve ambiguity when multiple beans of the same type exist.
//      If there are several beans of the same type, @Qualifier specifies which one to inject.
// The @Primary annotation is used to mark a bean as the default bean to be injected when there are multiple beans of the same type.
//      If no @Qualifier is used, Spring will inject the bean marked with @Primary.
// The @Autowired annotation in Spring is used for dependency injection. It allows Spring to automatically inject beans into a class.
// .
// Site Baeldung
// How to configure the Beans in the Spring Boot application (2 ways)
// Part 2:
// Read about docker, install Docker Desktop
// Run Postgres in Docker using docker-compose
// Read About JDBC, DriverManager, JPA
// One example with DriverManager
// One example with JDBC
// One example with JPA



@Component
public class University {
    private String name;
    private String location;
    private List<Faculty> faculties;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty getFacultyByName(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(name)) return faculty;
        }

        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = new ArrayList<>(faculties);
        for (Faculty faculty : this.faculties) {
            faculty.setFacultyForEveryStudent();
        }
    }

    public List<Student> findStudentsByName(String firstName, String lastName) {
        List<Student> matchingStudents = new ArrayList<>();
        for (Faculty faculty : faculties) {
            matchingStudents.addAll(faculty.findStudentsByName(firstName, lastName));
        }

        return matchingStudents;
    }

    @Override
    public String toString() {
       return "University [name=" + name + ", location=" + location + ", faculties=" + faculties + "]";
    }

}
