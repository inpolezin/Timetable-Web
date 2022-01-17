package com.example.diagramma.services;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.dto.TeacherDTO;
import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.entities.TeacherEntity;

import java.util.List;

public interface TeacherService {
    TeacherEntity createTeacher(TeacherDTO teacherDTO);
    List<TeacherDTO> getAllTeacherDTO();
    void deleteTeacherById(Long id);
    TeacherDTO getTeacherById(Long id);
}
