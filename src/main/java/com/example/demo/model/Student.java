package com.example.demo.model;

import com.example.demo.People;
import com.example.demo.enums.Awards;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class Student implements People {
    private String firstName;
    private String lastName;
    private int age;
    private Date signContractDate;
    private boolean onBudget;
    private String abbr;
    private String faculty;

    public Student() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.age = 18;
        this.signContractDate = new Date(2020, 1, 1);
        this.onBudget = false;
        this.abbr = "ST";
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

    @Override
    public void setAbbr(String abbr) {

        if (abbr.equals("ST")) {
            System.out.println("Student abbr: " + abbr);
        } else {
            System.out.println("Invalid abbr");
        }

        System.out.println("Student abbr: " + abbr);
    }

    public Awards getAward(BigDecimal grade) {
        if (grade.compareTo(new BigDecimal(90)) > 0) {
            return Awards.SECOND;
        }

        return Awards.NONE;
    }

    public Awards getAward(BigDecimal grade, BigDecimal lastYearGrade) {
        if (grade.compareTo(lastYearGrade) > 0) {
            return Awards.FIRST;
        }

        return Awards.NONE;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", signContractDate=" + signContractDate +
                ", onBudget=" + onBudget + ", abbr=" + abbr + ", faculty=" + faculty + "]";
    }
}
