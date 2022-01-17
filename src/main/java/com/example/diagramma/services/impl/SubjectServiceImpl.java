package com.example.diagramma.services.impl;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.repositories.SubjectRepository;
import com.example.diagramma.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public SubjectEntity createSubject(SubjectDTO subject) {
        SubjectEntity subjectEntity = new SubjectEntity(subject);
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public List<SubjectDTO> getAllSubjectDTO() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
}