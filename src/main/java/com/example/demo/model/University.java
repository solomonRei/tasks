package com.example.demo.model;

import org.springframework.stereotype.Component;

//TODO: add Faculty class, refresh DTOs, and update the service
// Create Faculty Service for getting facalty by name
// Create Faculty Controller for getting faculty by name using @PathVariable
// create method for Update faculty information by facultyName POST query, @RequestBody FacultyRequest
// Update University Model to have a list of faculties
// faculty has to have a name and a list of students
// create 2 different endpoints for getting students information:
//  The first one is for admin: It should return the whole information abput the student
//  The second one is for students: It should return only the student's name and the faculty name
// THEORY:
// Spring beans - types of beans, how to create them, how to inject them
// what is the @Qualifier annotation and how to use it
// what is the @Primary annotation and how to use it
// Where can I use @Autowired annotation
// What is the difference between @Component, @Service, @Repository, @Controller
// How to configure the Beans in the Spring Boot application (3 ways)




@Component
public class University {
    private Student student;
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Student getStudent() {
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
       return "University [student=" + student + ", name=" + name + ", location=" + location + "]";
    }

}
