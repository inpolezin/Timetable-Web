package com.example.diagramma.repositories;

import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity findTeacherEntityById(Long id);
}
