package com.example.diagramma.repositories;

import com.example.diagramma.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    GroupEntity findGroupEntityById(Long id);
}
