package com.example.demo.mappers;

import com.example.demo.api.response.FacultyDTO;
import com.example.demo.api.response.StudentUsualDTO;
import com.example.demo.model.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyMapper {
    public static FacultyDTO toFacultyDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faculty.getName());
        facultyDTO.setStudents(faculty.getStudents());
        setFacultyForEveryStudent(facultyDTO);

        return facultyDTO;
    }

    public static List<FacultyDTO> toFacultyDTO(List<Faculty> facultyList) {
        List<FacultyDTO> facultyDTOList = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            facultyDTOList.add(toFacultyDTO(faculty));
        }

        return facultyDTOList;
    }

    public static void setFacultyForEveryStudent(FacultyDTO facultyDTO) {
        for (StudentUsualDTO student : facultyDTO.getStudents()) {
            student.setFaculty(facultyDTO.getName());
        }
    }
}
