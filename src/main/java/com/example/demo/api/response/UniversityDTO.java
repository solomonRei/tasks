package com.example.demo.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UniversityDTO {
    @JsonProperty("university_name")
    private String name;
    @JsonProperty("university_location")
    private String location;

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
}
