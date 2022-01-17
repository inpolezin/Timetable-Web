package com.example.diagramma.services;

import com.example.diagramma.dto.TimetableDTO;
import com.example.diagramma.entities.DayOfWeek;
import com.example.diagramma.entities.TimetableEntity;

import java.util.List;

public interface TimetableService {
    boolean isEmptyByGroupId(Long id);
    TimetableEntity createTimetable(TimetableDTO timetableDTO);
    TimetableEntity updateTimetable(Long id, TimetableDTO timetableDTO);
    List<TimetableDTO> getAllTimetablesByGroupId(Long id);
    List<TimetableDTO> getAllTimetablesByTeacherId(Long id);
    boolean isEmptyByTeacherIdAndDayAndLesson(Long id, DayOfWeek day, int lesson, Long teacherId);
    void deleteAllTimetablesByGroupId(Long id);
}
