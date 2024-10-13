package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Data JPA automatically provides an implementation of the StudentRepository interface at runtime.
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("SELECT s FROM StudentEntity s WHERE s.firstName = :firstName AND s.lastName = :lastName")
    List<StudentEntity> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query("DELETE FROM StudentEntity s WHERE s.firstName = :firstName AND s.lastName = :lastName")
    void deleteByFullName(String firstName, String lastName);
}
