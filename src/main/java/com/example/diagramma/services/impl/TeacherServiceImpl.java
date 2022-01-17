package com.example.diagramma.services.impl;

import com.example.diagramma.dto.GroupDTO;
import com.example.diagramma.dto.TeacherDTO;
import com.example.diagramma.entities.TeacherEntity;
import com.example.diagramma.repositories.TeacherRepository;
import com.example.diagramma.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherEntity createTeacher(TeacherDTO teacherDTO) {
        TeacherEntity teacherEntity = new TeacherEntity(teacherDTO);
        return teacherRepository.save(teacherEntity);
    }

    @Override
    public List<TeacherDTO> getAllTeacherDTO() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        return new TeacherDTO(teacherRepository.findTeacherEntityById(id));
    }
}