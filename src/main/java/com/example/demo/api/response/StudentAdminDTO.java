package com.example.demo.api.response;

import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StudentAdminDTO extends StudentUsualDTO {
    @JsonProperty("age")
    private int age;
    @JsonProperty("sign_contract_date")
    private Date signContractDate;
    @JsonProperty("on_budget")
    private boolean onBudget;

    public StudentAdminDTO(Student student) {
        super(student);
        this.age = student.getAge();
        this.signContractDate = student.getSignContractDate();
        this.onBudget = student.isOnBudget();
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
}
