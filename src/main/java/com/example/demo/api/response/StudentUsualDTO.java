package com.example.demo.api.response;

import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentUsualDTO {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("abbreviation")
    private String abbr;
    @JsonProperty("faculty")
    private String faculty;


    public StudentUsualDTO(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.abbr = student.getAbbr();
        this.faculty = student.getFaculty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
