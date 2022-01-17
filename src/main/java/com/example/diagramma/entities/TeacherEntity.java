package com.example.diagramma.entities;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.dto.TeacherDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "teacher_name")
    private String teacherName;

    public TeacherEntity(TeacherDTO teacherDTO) {
        fromTeacherDTO(teacherDTO);
    }

    public void fromTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherName = teacherDTO.getName();
    }
}
