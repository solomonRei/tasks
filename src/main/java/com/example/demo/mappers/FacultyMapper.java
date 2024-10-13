package com.example.demo.mappers;

import com.example.demo.api.response.FacultyDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.entity.FacultyEntity;
import com.example.demo.model.Faculty;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.mappers.StudentMapper.*;

public class FacultyMapper {
    public static FacultyDTO toFacultyDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faculty.getName());
        facultyDTO.setStudents(faculty.getStudents());
        setFacultyForEveryStudent(facultyDTO);

        return facultyDTO;
    }

    public static FacultyDTO toFacultyDTO(FacultyEntity faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faculty.getName());
        facultyDTO.setStudents(toStudent(faculty.getStudents()));
        setFacultyForEveryStudent(facultyDTO);

        return facultyDTO;
    }

    public static List<FacultyDTO> toFacultyDTO(List<FacultyEntity> facultyList) {
        List<FacultyDTO> facultyDTOList = new ArrayList<>();
        for (FacultyEntity faculty : facultyList) {
            facultyDTOList.add(toFacultyDTO(faculty));
        }

        return facultyDTOList;
    }

    public static void setFacultyForEveryStudent(FacultyDTO facultyDTO) {
        for (StudentUsualDTO student : facultyDTO.getStudents()) {
            student.setFaculty(facultyDTO.getName());
        }
    }

    public static FacultyEntity toFacultyEntity(Faculty faculty) {
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(faculty.getName());
        facultyEntity.setStudents(toStudentEntity(faculty.getStudents()));

        return facultyEntity;
    }

    public static List<FacultyEntity> toFacultyEntity(List<Faculty> facultyList) {
        List<FacultyEntity> facultyEntityList = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            facultyEntityList.add(toFacultyEntity(faculty));
        }

        return facultyEntityList;
    }

    public static Faculty toFaculty(FacultyEntity facultyEntity) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyEntity.getName());
        faculty.setStudents(toStudent(facultyEntity.getStudents()));

        return faculty;
    }

    public static List<Faculty> toFaculty(List<FacultyEntity> facultyEntityList) {
        List<Faculty> facultyList = new ArrayList<>();
        for (FacultyEntity facultyEntity : facultyEntityList) {
            facultyList.add(toFaculty(facultyEntity));
        }

        return facultyList;
    }

    public static Faculty toFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDTO.getName());
        faculty.setStudents(toStudentList(facultyDTO.getStudents()));

        return faculty;
    }

    public static List<Faculty> toFacultyList(List<FacultyDTO> facultyDTOList) {
        List<Faculty> facultyList = new ArrayList<>();
        for (FacultyDTO facultyDTO : facultyDTOList) {
            facultyList.add(toFaculty(facultyDTO));
        }

        return facultyList;
    }
}
