package com.example.demo.service;

import com.example.demo.api.response.StudentAdminDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.FacultyEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.Student;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.example.demo.mappers.StudentMapper.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository, UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
    }

    public Student createStudent(String firstName, String lastName, int age, Date signContractDate, boolean onBudget, String abbr, String facultyName, String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);
        FacultyEntity facultyEntity = facultyRepository.findByName(facultyName, universityEntity);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(firstName);
        studentEntity.setLastName(lastName);
        studentEntity.setAge(age);
        studentEntity.setSignContractDate(signContractDate);
        studentEntity.setOnBudget(onBudget);
        studentEntity.setAbbr(abbr);
        studentEntity.setFaculty(facultyEntity);
        studentEntity.setUniversity(universityEntity);

        return toStudent(studentRepository.save(studentEntity));
    }

    @Transactional
    public void updateStudent(StudentEntity studentEntity, String newFirstName, String newLastName, int newAge, Date newSignContractDate, boolean newOnBudget, String newAbbr, String newFacultyName, String newUniversityName) {
        UniversityEntity newUniversityEntity = universityRepository.findByName(newUniversityName);
        FacultyEntity newFacultyEntity = facultyRepository.findByName(newFacultyName, newUniversityEntity);

        studentEntity.setFirstName(newFirstName);
        studentEntity.setLastName(newLastName);
        studentEntity.setAge(newAge);
        studentEntity.setSignContractDate(newSignContractDate);
        studentEntity.setOnBudget(newOnBudget);
        studentEntity.setAbbr(newAbbr);
        studentEntity.setFaculty(newFacultyEntity);
        studentEntity.setUniversity(newUniversityEntity);

        studentRepository.save(studentEntity);
    }

    public List<StudentUsualDTO> getUsualStudent(String firstName, String lastName) {
        return toStudentUsualDTOList(studentRepository.findByFullName(firstName, lastName));
    }

    public List<StudentAdminDTO> getAdminStudent(String firstName, String lastName) {
        return toStudentAdminDTOList(studentRepository.findByFullName(firstName, lastName));
    }

    public StudentEntity getStudent(String firstName, String lastName) {
        return studentRepository.findByFullName(firstName, lastName).get(0);
    }

    public List<StudentUsualDTO> getAllUsualStudents() {
        return toStudentUsualDTOList(studentRepository.findAll());
    }

    public List<StudentAdminDTO> getAllAdminStudents() {
        return toStudentAdminDTOList(studentRepository.findAll());
    }

    @Transactional
    public void deleteStudent(String firstName, String lastName) {
        studentRepository.deleteByFullName(firstName, lastName);
    }
}
