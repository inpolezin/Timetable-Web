package com.example.diagramma.dto;

import com.example.diagramma.entities.SubjectEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDTO {
    private Long id;
    private String name;

    public SubjectDTO(SubjectEntity subjectEntity) {
        fromSubjectEntity(subjectEntity);
    }

    public void fromSubjectEntity(SubjectEntity subjectEntity) {
        this.id = subjectEntity.getId();
        this.name = subjectEntity.getSubjectName();
    }
}
