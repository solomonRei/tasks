package com.example.demo.service;

import com.example.demo.api.response.FacultyDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.FacultyEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.Student;
import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mappers.FacultyMapper.*;
import static com.example.demo.mappers.StudentMapper.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    public FacultyService(FacultyRepository facultyRepository, UniversityRepository universityRepository) {
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
    }

    public Faculty createFaculty(String name, List<Student> students, String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(name);

        List<StudentEntity> studentEntities = toStudentEntity(students);
        for (StudentEntity studentEntity : studentEntities) {
            studentEntity.setFaculty(facultyEntity);
            studentEntity.setUniversity(universityEntity);
        }

        facultyEntity.setStudents(studentEntities);
        facultyEntity.setUniversity(universityEntity);

        return toFaculty(facultyRepository.save(facultyEntity));
    }

    @Transactional
    public void updateFaculty(FacultyEntity facultyEntity, String newName, List<Student> newStudents, String newUniversityName) {
        UniversityEntity newUniversityEntity = universityRepository.findByName(newUniversityName);
        facultyEntity.setName(newName);

        List<StudentEntity> newStudentEntities = toStudentEntity(newStudents);
        for (StudentEntity studentEntity : newStudentEntities) {
            studentEntity.setFaculty(facultyEntity);
        }

        facultyEntity.setStudents(newStudentEntities);
        facultyEntity.setUniversity(newUniversityEntity);

        facultyRepository.save(facultyEntity);
    }

    public FacultyDTO getFaculty(String facultyName, String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);

        return toFacultyDTO(facultyRepository.findByName(facultyName, universityEntity));
    }

    public FacultyEntity getFacultyEntity(String facultyName, String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);

        return facultyRepository.findByName(facultyName, universityEntity);
    }

    public List<FacultyDTO> getAllFaculties() {
        return toFacultyDTO(facultyRepository.findAll());
    }

    public List<FacultyDTO> getAllFacultiesByUniversityName(String universityName) {
        Long universityId = universityRepository.getUniversityIdByName(universityName);

        return toFacultyDTO(facultyRepository.findByUniversityId(universityId));
    }

    public List<StudentUsualDTO> getAllUsualStudents(String facultyName, String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);
        FacultyEntity facultyEntity = facultyRepository.findByName(facultyName, universityEntity);

        return toStudentUsualDTOList(facultyRepository.findStudentsByFaculty(facultyEntity, universityEntity));
    }

    @Transactional
    public void deleteFaculty(String name) {
        facultyRepository.deleteByName(name);
    }
}
