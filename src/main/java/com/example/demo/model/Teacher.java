package com.example.demo.model;

import com.example.demo.People;
import org.springframework.stereotype.Component;

@Component
public class Teacher implements People {

    @Override
    public void setAbbr(String abbr) {
        System.out.println("Teacher abbr: " + abbr);
    }
}
