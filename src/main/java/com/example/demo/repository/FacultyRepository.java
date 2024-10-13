package com.example.demo.repository;

import com.example.demo.entity.FacultyEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Data JPA automatically provides an implementation of the FacultyRepository interface at runtime.
@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
    @Query("SELECT f FROM FacultyEntity f WHERE f.name = :facultyName AND f.university = :university")
    FacultyEntity findByName(@Param("facultyName") String facultyName, @Param("university") UniversityEntity university);

    List<FacultyEntity> findByUniversityId(Long universityId);

    @Query("SELECT s FROM StudentEntity s WHERE s.faculty = :faculty AND s.university = :university")
    List<StudentEntity> findStudentsByFaculty(@Param("faculty") FacultyEntity faculty, @Param("university") UniversityEntity university);

    void deleteByName(String name);
}
