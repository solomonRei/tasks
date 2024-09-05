package com.example.demo.service;

import com.example.demo.api.response.UniversityDTO;
import com.example.demo.entity.UniversityEntity;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

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

    public University createUniversity(String name, String location, Student student) {
        University university = new University();
        university.setName(name);
        university.setLocation(location);
        university.setStudent(student);
        return university;
    }

}
