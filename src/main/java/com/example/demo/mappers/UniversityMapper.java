package com.example.demo.mappers;

import com.example.demo.api.response.UniversityDTO;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.University;
import jakarta.persistence.EntityNotFoundException;

import static com.example.demo.mappers.FacultyMapper.*;

public class UniversityMapper {
    public static University toUniversity(UniversityEntity universityEntity) {
        University university = new University();
        university.setName(universityEntity.getName());
        university.setLocation(universityEntity.getLocation());
        university.setFaculties(toFaculty(universityEntity.getFaculties()));

        return university;
    }

    public static University toUniversity(UniversityDTO universityDTO) {
        University university = new University();
        university.setName(universityDTO.getName());
        university.setLocation(universityDTO.getLocation());
        university.setFaculties(toFacultyList(universityDTO.getFaculties()));

        return university;
    }

    public static UniversityEntity toUniversityEntity(University university) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(university.getName());
        universityEntity.setLocation(university.getLocation());
        universityEntity.setFaculties(toFacultyEntity(university.getFaculties()));

        return universityEntity;
    }

    public static UniversityDTO toUniversityDTO(UniversityEntity universityEntity) {
        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setName(universityEntity.getName());
        universityDTO.setLocation(universityEntity.getLocation());
        universityDTO.setFaculties(toFacultyDTO(universityEntity.getFaculties()));

        return universityDTO;
    }
}
