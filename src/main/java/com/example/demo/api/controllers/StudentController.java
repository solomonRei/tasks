package com.example.demo.api.controllers;

import com.example.demo.api.requests.StudentRequest;
import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create/{universityName}/{facultyName}")
    public void createStudent(@RequestBody StudentRequest studentRequest, @PathVariable String universityName, @PathVariable String facultyName) {
        Student student = studentService.createStudent(
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getAge(),
                studentRequest.getSignContractDate(),
                studentRequest.isOnBudget(),
                studentRequest.getAbbr(),
                facultyName,
                universityName
        );

        System.out.println("Created student: " + student);
    }

    @PostMapping("/update/{universityName}/{facultyName}/{firstName}/{lastName}")
    public void updateStudent(@PathVariable String universityName, @PathVariable String facultyName, @PathVariable String firstName, @PathVariable String lastName, @RequestBody StudentRequest studentRequest) {
        StudentEntity studentEntity = studentService.getStudent(firstName, lastName);
        if (studentEntity != null) {
            studentService.updateStudent(
                    studentEntity,
                    studentRequest.getFirstName(),
                    studentRequest.getLastName(),
                    studentRequest.getAge(),
                    studentRequest.getSignContractDate(),
                    studentRequest.isOnBudget(),
                    studentRequest.getAbbr(),
                    facultyName,
                    universityName
            );
        }
        else {
            throw new RuntimeException("Student " + firstName + " " + lastName + " doesn't exist.");
        }

        System.out.println("Updated student " + firstName + " " + lastName);
    }

    @GetMapping("/getStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentUsualDTO>> getUsualStudent(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentUsualDTO> studentUsualDTO = studentService.getUsualStudent(firstName, lastName);

        return ResponseEntity.ok(studentUsualDTO);
    }

    @GetMapping("/getAdminStudent/{firstName}/{lastName}")
    public ResponseEntity<List<StudentAdminDTO>> getAdminStudent(@PathVariable String firstName, @PathVariable String lastName) {
        List<StudentAdminDTO> studentAdminDTO = studentService.getAdminStudent(firstName, lastName);

        return ResponseEntity.ok(studentAdminDTO);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentUsualDTO>> getAllUsualStudents() {
        System.out.println("HERE");
        List<StudentUsualDTO> studentUsualDTOList = studentService.getAllUsualStudents();
        System.out.println(studentUsualDTOList);

        return ResponseEntity.ok(studentUsualDTOList);
    }

    @GetMapping("/getAllAdminStudents")
    public ResponseEntity<List<StudentAdminDTO>> getAllAdminStudents() {
        List<StudentAdminDTO> studentAdminDTOList = studentService.getAllAdminStudents();

        return ResponseEntity.ok(studentAdminDTOList);
    }

    @DeleteMapping("/delete/{firstName}/{lastName}")
    public void deleteStudent(@PathVariable String firstName, @PathVariable String lastName) {
        studentService.deleteStudent(firstName, lastName);
        System.out.println("Deleted student: " + firstName + " " + lastName);
    }
}
