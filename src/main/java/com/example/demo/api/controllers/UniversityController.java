package com.example.demo.api.controllers;

import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.model.Faculty;
import com.example.demo.api.requests.UniversityRequest;
import com.example.demo.api.requests.FacultyRequest;
import com.example.demo.api.response.UniversityDTO;
import com.example.demo.api.response.FacultyDTO;
import com.example.demo.service.UniversityService;
import com.example.demo.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/create")
    public void createUniversity(@RequestBody UniversityRequest request) {
        University university = universityService.createUniversity(
                request.getName(),
                request.getLocation(),
                request.getFaculties()
        );

        System.out.println(university);
    }

    @GetMapping("/")
    public ResponseEntity<UniversityDTO> getUniversity() {
        University uni = universityService.getUniversity();

        UniversityDTO university = new UniversityDTO();
        university.setName(uni.getName());
        university.setLocation(uni.getLocation());
        university.setFaculties(uni.getFaculties());

        return ResponseEntity.ok(university);
    }

    @GetMapping("/getFaculty/{name}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable String name) {
        Faculty fac = universityService.getFaculty(name);
        FacultyDTO faculty = new FacultyDTO(fac);

        return ResponseEntity.ok(faculty);
    }

    @PostMapping("/updateFaculty/{name}")
    public void updateFaculty(@PathVariable String name, @RequestBody FacultyRequest request) {
        FacultyService facSer = new FacultyService(universityService.getFaculty(name));
        facSer.setFaculty(request);

        System.out.println(facSer);
    }

    @GetMapping("/getStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentUsualDTO>> getStudent(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentUsualDTO> matchingStudents = new ArrayList<>();
        for (Student student : universityService.findStudentsByName(firstName, lastName)) {
            matchingStudents.add(new StudentUsualDTO(student));
        }

        return ResponseEntity.ok(matchingStudents);
    }

    @GetMapping("/admin/getStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentAdminDTO>> getStudentForAdmin(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentAdminDTO> matchingStudents = new ArrayList<>();
        for (Student student : universityService.findStudentsByName(firstName, lastName)) {
            matchingStudents.add(new StudentAdminDTO(student));
        }

        return ResponseEntity.ok(matchingStudents);
    }

    // DTO - Data Transfer Object
    // DAO - Data Access Object
}
