package com.example.demo.service;

import com.example.demo.model.Faculty;
import com.example.demo.api.response.UniversityDTO;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final University university;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public UniversityDTO getUniversity(String name) {
        UniversityEntity entity = universityRepository.findByName(name);
        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setName(entity.getName());
        universityDTO.setLocation(entity.getLocation());

        return universityDTO;
    }
  
    public Faculty getFaculty(String name) {
        return university.getFacultyByName(name);
    }

    public List<Faculty> getFaculties() {
        return university.getFaculties();
    }

    public University createUniversity(String name, String location, List<Faculty> faculties) {
        university.setName(name);
        university.setLocation(location);
        university.setFaculties(faculties);

        return university;
    }

    public List<Student> findStudentsByName(String firstName, String lastName) {
        return university.findStudentsByName(firstName, lastName);
    }
}
