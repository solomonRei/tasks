package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "signContractDate")
    private Date signContractDate;

    @Column(name = "budget")
    private boolean onBudget;

    @Column(name = "abbr")
    private String abbr;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getSignContractDate() {
        return signContractDate;
    }

    public void setSignContractDate(Date signContractDate) {
        this.signContractDate = signContractDate;
    }

    public boolean isOnBudget() {
        return onBudget;
    }

    public void setOnBudget(boolean onBudget) {
        this.onBudget = onBudget;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    public UniversityEntity getUniversity() {
        return university;
    }

    public void setUniversity(UniversityEntity university) {
        this.university = university;
    }
}
