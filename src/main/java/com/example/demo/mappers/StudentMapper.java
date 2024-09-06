package com.example.demo.mappers;

import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public static StudentUsualDTO toStudentUsualDTO(Student student) {
        return new StudentUsualDTO(student);
    }

    public static StudentAdminDTO toStudentAdminDTO(Student student) {
        return new StudentAdminDTO(student);
    }

    public static List<StudentUsualDTO> toStudentUsualDTO(List<Student> students) {
        return students.stream()
            .map(StudentMapper::toStudentUsualDTO)
            .collect(Collectors.toList());
    }

    public static List<StudentAdminDTO> toStudentAdminDTO(List<Student> students) {
        return students.stream()
                .map(StudentMapper::toStudentAdminDTO)
                .collect(Collectors.toList());
    }
}
