package com.example.diagramma.services;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.entities.SubjectEntity;

import java.util.List;

public interface SubjectService {
    SubjectEntity createSubject(SubjectDTO subjectDTO);
    List<SubjectDTO> getAllSubjectDTO();
    void deleteSubjectById(Long id);
}
