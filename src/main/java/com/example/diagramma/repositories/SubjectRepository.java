package com.example.diagramma.repositories;

import com.example.diagramma.entities.GroupEntity;
import com.example.diagramma.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    SubjectEntity findSubjectEntityById(Long id);
}
