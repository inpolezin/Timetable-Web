package com.example.diagramma.dto;

import com.example.diagramma.entities.DayOfWeek;
import com.example.diagramma.entities.GroupEntity;
import com.example.diagramma.entities.SubjectEntity;
import com.example.diagramma.entities.TimetableEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TimetableDTO {
    private Long id;
    private Long groupId;
    private DayOfWeek day;
    private int lesson;
    private Long subjectId;
    private Long teacherId;

    public TimetableDTO(TimetableEntity timetableEntity) {
        this.id = timetableEntity.getId();
        this.groupId = timetableEntity.getGroup().getId();
        this.day = timetableEntity.getDayOfWeek();
        this.lesson = timetableEntity.getLesson();
        this.subjectId = timetableEntity.getSubject().getId();
        this.teacherId = timetableEntity.getTeacher().getId();
    }
}
