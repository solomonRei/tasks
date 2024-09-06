package com.example.demo.api.controllers;

import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
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

import java.util.List;

import static com.example.demo.mappers.FacultyMapper.toFacultyDTO;
import static com.example.demo.mappers.StudentMapper.toStudentAdminDTO;
import static com.example.demo.mappers.StudentMapper.toStudentUsualDTO;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private UniversityService universityService;
    private FacultyService facultyService;

    @Autowired
    public UniversityController(UniversityService universityService, FacultyService facultyService) {
        this.universityService = universityService;
        this.facultyService = facultyService;
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

    @GetMapping("/{name}")
    public ResponseEntity<UniversityDTO> getUniversity(@PathVariable String name) {
        UniversityDTO university = universityService.getUniversity(name);

        return ResponseEntity.ok(university);
    }

    @GetMapping("/getFaculty/{name}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable String name) {
        FacultyDTO facultyDTO = toFacultyDTO(universityService.getFaculty(name));

        return ResponseEntity.ok(facultyDTO);
    }

    @PostMapping("/updateFaculty/{name}")
    public void updateFaculty(@PathVariable String name, @RequestBody FacultyRequest request) {
        Faculty faculty = universityService.getFaculty(name);
        if (faculty != null) facultyService.updateFaculty(faculty, request.getName(), request.getStudents());
        else throw new RuntimeException("faculty is null");

        System.out.println(universityService.getFaculty(name));
    }

    @GetMapping("/getStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentUsualDTO>> getStudent(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentUsualDTO> matchingStudents = toStudentUsualDTO(universityService.findStudentsByName(firstName, lastName));

        return ResponseEntity.ok(matchingStudents);
    }

    @GetMapping("/admin/getStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentAdminDTO>> getStudentForAdmin(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentAdminDTO> matchingStudents = toStudentAdminDTO(universityService.findStudentsByName(firstName, lastName));

        return ResponseEntity.ok(matchingStudents);
    }

    // DTO - Data Transfer Object
    // DAO - Data Access Object
}
