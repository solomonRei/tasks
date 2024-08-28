package com.example.demo.model;

import com.example.demo.People;
import com.example.demo.enums.Awards;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Student implements People {
    private String firstName;
    private String lastName;
    private String abbr;

    public Student() {
        this.firstName = "firstName";
        this.lastName = "lastName";
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public void setAbbr(String abbr) {

        if (abbr.equals("STU")) {
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
}
