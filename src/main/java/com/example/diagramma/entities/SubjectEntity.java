package com.example.diagramma.entities;

import com.example.diagramma.dto.SubjectDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    public SubjectEntity(SubjectDTO subjectDTO) {
        fromSubjectDTO(subjectDTO);
    }

    public void fromSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectName = subjectDTO.getName();
    }
}
