package com.example.diagramma.entities;


import com.example.diagramma.dto.TimetableDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor
@Entity
@Data
@Table(name = "timetables")
public class TimetableEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private DayOfWeek dayOfWeek;

    @Column(name = "lesson")
    private int lesson;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    public TimetableEntity(TimetableDTO timetableDTO) {
        fromTimetableDTO(timetableDTO);
    }

    public void fromTimetableDTO(TimetableDTO timetableDTO) {
        this.dayOfWeek = timetableDTO.getDay();
        this.lesson = timetableDTO.getLesson();

    }
}
