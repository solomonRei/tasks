package com.example.demo.api.requests;

import com.example.demo.model.Faculty;

import java.util.Date;

public class StudentRequest {
    private String firstName;
    private String lastName;
    private int age;
    private Date signContractDate;
    private boolean onBudget;
    private String abbr;
    private String faculty;
    private String university;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAbbr() {
        return abbr;
    }

    public int getAge() {
        return age;
    }

    public Date getSignContractDate() {
        return signContractDate;
    }

    public boolean isOnBudget() {
        return onBudget;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSignContractDate(Date signContractDate) {
        this.signContractDate = signContractDate;
    }

    public void setOnBudget(boolean onBudget) {
        this.onBudget = onBudget;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty.getName();
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
