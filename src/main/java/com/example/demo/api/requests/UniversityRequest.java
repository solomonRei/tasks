package com.example.demo.api.requests;

import com.example.demo.model.Faculty;

import java.util.List;

public class UniversityRequest {
    private String name;
    private String location;
    private List<Faculty> faculties;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
