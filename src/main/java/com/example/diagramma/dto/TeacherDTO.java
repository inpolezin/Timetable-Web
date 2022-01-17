package com.example.diagramma.dto;

import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.entities.TeacherEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO {
    private Long id;
    private String name;

    public TeacherDTO(TeacherEntity teacherEntity) {
        fromTeacherEntity(teacherEntity);
    }

    public void fromTeacherEntity(TeacherEntity teacherEntity) {
        this.id = teacherEntity.getId();
        this.name = teacherEntity.getTeacherName();
    }
}
