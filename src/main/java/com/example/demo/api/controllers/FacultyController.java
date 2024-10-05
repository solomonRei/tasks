package com.example.demo.api.controllers;

import com.example.demo.api.requests.FacultyRequest;
import com.example.demo.api.response.FacultyDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.FacultyEntity;
import com.example.demo.model.Faculty;
import com.example.demo.service.FacultyService;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService, UniversityService universityService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/create/{universityName}")
    public void createFaculty(@RequestBody FacultyRequest facultyRequest, @PathVariable String universityName) {
        FacultyEntity facultyEntity = facultyService.getFacultyEntity(facultyRequest.getName(), universityName);
        if (facultyEntity != null) {
            throw new RuntimeException("Faculty with this name already exists");
        }

        Faculty faculty = facultyService.createFaculty(
                facultyRequest.getName(),
                facultyRequest.getStudents(),
                universityName
        );

        System.out.println("Created faculty" + faculty);
    }

    @PostMapping("/update/{universityName}/{facultyName}")
    public void updateFaculty(@PathVariable String universityName, @PathVariable String facultyName, @RequestBody FacultyRequest facultyRequest) {
        FacultyEntity facultyEntity = facultyService.getFacultyEntity(facultyName, universityName);
        if (facultyEntity != null) {
            facultyService.updateFaculty(
                    facultyEntity,
                    facultyEntity.getName(),
                    facultyRequest.getStudents(),
                    universityName
            );
        }
        else {
            throw new RuntimeException("Faculty " + facultyName + " doesn't exist.");
        }

        System.out.println("Updated faculty " + facultyName);
    }

    @GetMapping("/getFaculty/{universityName}/{facultyName}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable String universityName, @PathVariable String facultyName) {
        FacultyDTO facultyDTO = facultyService.getFaculty(facultyName, universityName);

        return ResponseEntity.ok(facultyDTO);
    }

    @GetMapping("/getAllFaculties")
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        List<FacultyDTO> facultyDTOList = facultyService.getAllFaculties();

        return ResponseEntity.ok(facultyDTOList);
    }

    @GetMapping("/getAllFaculties/{universityName}")
    public ResponseEntity<List<FacultyDTO>> getAllUniversityFaculties(@PathVariable String universityName) {
        List<FacultyDTO> facultyDTOList = facultyService.getAllFacultiesByUniversityName(universityName);

        return ResponseEntity.ok(facultyDTOList);
    }

    @GetMapping("/getStudents/{universityName}/{facultyName}")
    public ResponseEntity<List<StudentUsualDTO>> getStudents(@PathVariable String universityName, @PathVariable String facultyName) {
        List<StudentUsualDTO> studentUsualDTOList = facultyService.getAllUsualStudents(facultyName, universityName);

        return ResponseEntity.ok(studentUsualDTOList);
    }

    @DeleteMapping("/delete/{facultyName}")
    public void deleteFaculty(@PathVariable String facultyName) {
        facultyService.deleteFaculty(facultyName);
        System.out.println("Deleted faculty " + facultyName);
    }
}
