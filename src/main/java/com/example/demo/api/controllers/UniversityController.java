package com.example.demo.api.controllers;

import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.University;
import com.example.demo.api.requests.UniversityRequest;
import com.example.demo.api.response.UniversityDTO;
import com.example.demo.api.response.FacultyDTO;
import com.example.demo.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/create")
    public void createUniversity(@RequestBody UniversityRequest universityRequest) {
        UniversityEntity universityEntity = universityService.getUniversityEntity(universityRequest.getName());
        if (universityEntity != null) {
            throw new RuntimeException("University with this name already exists");
        }

        University university = universityService.createUniversity(
                universityRequest.getName(),
                universityRequest.getLocation(),
                universityRequest.getFaculties()
        );

        System.out.println("Created university: " + university);
    }

    @PostMapping("/update/{universityName}")
    public void updateUniversity(@PathVariable String universityName, @RequestBody UniversityRequest universityRequest) {
        UniversityEntity universityEntity = universityService.getUniversityEntity(universityName);
        if (universityEntity != null) {
            universityService.updateUniversity(
                    universityEntity,
                    universityRequest.getName(),
                    universityRequest.getLocation(),
                    universityRequest.getFaculties()
            );
        }
        else {
            throw new RuntimeException("University " + universityRequest + " doesn't exist");
        }

        System.out.println("Updated university: " + universityEntity);
    }

    @GetMapping("/{universityName}")
    public ResponseEntity<UniversityDTO> getUniversity(@PathVariable String universityName) {
        UniversityDTO university = universityService.getUniversity(universityName);

        return ResponseEntity.ok(university);
    }

    @GetMapping("/getFaculties/{universityName}")
    public ResponseEntity<List<FacultyDTO>> getFaculties(@PathVariable String universityName) {
        List<FacultyDTO> facultyDTOList = universityService.getUniversityFaculties(universityName);

        return ResponseEntity.ok(facultyDTOList);
    }

    @GetMapping("/getStudents/{universityName}")
    public ResponseEntity<List<StudentUsualDTO>> getStudents(@PathVariable String universityName) {
        List<StudentUsualDTO> studentUsualDTOList = universityService.getUniversityStudents(universityName);

        return ResponseEntity.ok(studentUsualDTOList);
    }

    @DeleteMapping("/delete/{universityName}")
    public void deleteUniversity(@PathVariable String universityName) {
        universityService.deleteUniversity(universityName);
        System.out.println("Deleted university: " + universityName);
    }

    // DTO - Data Transfer Object
    // DAO - Data Access Object
}
