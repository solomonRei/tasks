package com.example.demo.mappers;

import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.StudentEntity;
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

    public static List<StudentUsualDTO> toStudentUsualDTO(List<Student> studentsList) {
        return studentsList.stream()
            .map(StudentMapper::toStudentUsualDTO)
            .collect(Collectors.toList());
    }

    public static List<StudentAdminDTO> toStudentAdminDTO(List<Student> studentsList) {
        return studentsList.stream()
                .map(StudentMapper::toStudentAdminDTO)
                .collect(Collectors.toList());
    }

    public static StudentEntity toStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setAge(student.getAge());
        studentEntity.setOnBudget(student.isOnBudget());
        studentEntity.setAbbr(student.getAbbr());
        studentEntity.setSignContractDate(student.getSignContractDate());

        return studentEntity;
    }

    public static List<StudentEntity> toStudentEntity(List<Student> studentsList) {
        return studentsList.stream()
                .map(StudentMapper::toStudentEntity)
                .collect(Collectors.toList());
    }

    public static Student toStudent(StudentEntity studentEntity) {
        Student student = new Student();
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());
        student.setAge(studentEntity.getAge());
        student.setAbbr(studentEntity.getAbbr());
        student.setSignContractDate(studentEntity.getSignContractDate());
        student.setOnBudget(studentEntity.isOnBudget());

        return student;
    }

    public static List<Student> toStudent(List<StudentEntity> studentEntityList) {
        return studentEntityList.stream()
                .map(StudentMapper::toStudent)
                .collect(Collectors.toList());
    }

    public static Student toStudent(StudentUsualDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAbbr(studentDTO.getAbbr());

        return student;
    }

    public static List<Student> toStudentList(List<StudentUsualDTO> studentDTOList) {
        return studentDTOList.stream()
                .map(StudentMapper::toStudent)
                .collect(Collectors.toList());
    }

    public static StudentUsualDTO toStudentUsualDTO(StudentEntity studentEntity) {
        return new StudentUsualDTO(toStudent(studentEntity));
    }

    public static List<StudentUsualDTO> toStudentUsualDTOList(List<StudentEntity> studentEntityList) {
        return studentEntityList.stream()
                .map(studentEntity -> {
                    StudentUsualDTO studentUsualDTO = toStudentUsualDTO(studentEntity);
                    studentUsualDTO.setFaculty(studentEntity.getFaculty().getName());

                    return studentUsualDTO;
                })
                .collect(Collectors.toList());
    }

    public static StudentAdminDTO toStudentAdminDTO(StudentEntity studentEntity) {
        return new StudentAdminDTO(toStudent(studentEntity));
    }

    public static List<StudentAdminDTO> toStudentAdminDTOList(List<StudentEntity> studentEntityList) {
        return studentEntityList.stream()
                .map(studentEntity -> {
                    StudentAdminDTO studentAdminDTO = toStudentAdminDTO(studentEntity);
                    studentAdminDTO.setFaculty(studentEntity.getFaculty().getName());

                    return studentAdminDTO;
                })
                .collect(Collectors.toList());
    }
}
