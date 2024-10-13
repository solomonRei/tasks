package com.example.demo.repository;

import com.example.demo.entity.FacultyEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Data JPA automatically provides an implementation of the UniversityRepository interface at runtime.
@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
    UniversityEntity findByName(String name);

    @Query("SELECT u.id FROM UniversityEntity u WHERE u.name = :name")
    Long getUniversityIdByName(@Param("name") String name);

    @Query("SELECT f FROM FacultyEntity f WHERE f.university = :university")
    List<FacultyEntity> findFacultiesByUniversity(@Param("university") UniversityEntity university);

    @Query("SELECT s FROM StudentEntity s WHERE s.university = :university")
    List<StudentEntity> findStudentsByUniversity(@Param("university") UniversityEntity university);

    void deleteByName(String name);
}
