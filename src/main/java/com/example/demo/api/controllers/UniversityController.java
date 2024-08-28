package com.example.demo.api.controllers;

import com.example.demo.model.University;
import com.example.demo.api.requests.UniversityRequest;
import com.example.demo.api.response.UniversityDTO;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/")
    public ResponseEntity<UniversityDTO> getUniversity() {
        University uni = universityService.getUniversity();

        UniversityDTO university = new UniversityDTO();
        university.setName(uni.getName());
        university.setLocation(uni.getLocation());

        return ResponseEntity.ok(university);
    }

    @PostMapping("/create")
    public void createUniversity(@RequestBody UniversityRequest request) {
        University university = universityService.createUniversity(
                request.getName(),
                request.getLocation(),
                request.getStudent()
        );

        System.out.println(university);
    }

    // DTO - Data Transfer Object
    // DAO - Data Access Object
}
