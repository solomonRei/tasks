package com.example.demo.api.response;

import com.example.demo.model.Faculty;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UniversityDTO {
    @JsonProperty("university_name")
    private String name;
    @JsonProperty("university_location")
    private String location;
    @JsonProperty("university_faculties")
    private List<FacultyDTO> faculties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<FacultyDTO> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties.stream()
                .map(FacultyDTO::new)
                .toList();
    }
}
