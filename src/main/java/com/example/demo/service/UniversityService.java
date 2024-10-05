package com.example.demo.service;

import com.example.demo.api.response.FacultyDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.FacultyEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.Faculty;
import com.example.demo.api.response.UniversityDTO;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mappers.FacultyMapper.*;
import static com.example.demo.mappers.StudentMapper.toStudentUsualDTOList;
import static com.example.demo.mappers.UniversityMapper.toUniversity;
import static com.example.demo.mappers.UniversityMapper.toUniversityDTO;

@Service
public class UniversityService {
    @Autowired
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University createUniversity(String name, String location, List<Faculty> faculties) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(name);
        universityEntity.setLocation(location);

        List<FacultyEntity> facultyEntities = toFacultyEntity(faculties);
        for (FacultyEntity facultyEntity : facultyEntities) {
            facultyEntity.setUniversity(universityEntity);
            for (StudentEntity studentEntity : facultyEntity.getStudents()) {
                studentEntity.setFaculty(facultyEntity);
                studentEntity.setUniversity(universityEntity);
            }
        }

        universityEntity.setFaculties(facultyEntities);

        return toUniversity(universityRepository.save(universityEntity));
    }

    public void updateUniversity(UniversityEntity universityEntity, String newName, String newLocation, List<Faculty> newFaculties) {
        universityEntity.setName(newName);
        universityEntity.setLocation(newLocation);

        List<FacultyEntity> facultyEntities = toFacultyEntity(newFaculties);
        for (FacultyEntity facultyEntity : facultyEntities) {
            facultyEntity.setUniversity(universityEntity);
            for (StudentEntity studentEntity : facultyEntity.getStudents()) {
                studentEntity.setFaculty(facultyEntity);
                studentEntity.setUniversity(universityEntity);
            }
        }

        universityEntity.setFaculties(facultyEntities);

        universityRepository.save(universityEntity);
    }

    public UniversityDTO getUniversity(String name) {
        return toUniversityDTO(universityRepository.findByName(name));
    }

    public UniversityEntity getUniversityEntity(String name) {
        return universityRepository.findByName(name);
    }

    public List<FacultyDTO> getUniversityFaculties(String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);

        return toFacultyDTO(universityRepository.findFacultiesByUniversity(universityEntity));
    }

    public List<StudentUsualDTO> getUniversityStudents(String universityName) {
        UniversityEntity universityEntity = universityRepository.findByName(universityName);

        return toStudentUsualDTOList(universityRepository.findStudentsByUniversity(universityEntity));
    }

    @Transactional
    public void deleteUniversity(String name) {
        universityRepository.deleteByName(name);
    }
}
