package com.example.diagramma.services.impl;

import com.example.diagramma.dto.TeacherDTO;
import com.example.diagramma.dto.TimetableDTO;
import com.example.diagramma.entities.DayOfWeek;
import com.example.diagramma.entities.TeacherEntity;
import com.example.diagramma.entities.TimetableEntity;
import com.example.diagramma.repositories.GroupRepository;
import com.example.diagramma.repositories.SubjectRepository;
import com.example.diagramma.repositories.TeacherRepository;
import com.example.diagramma.repositories.TimetableRepository;

import com.example.diagramma.services.TimetableService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {
    private final TimetableRepository timetableRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final GroupRepository groupRepository;

    @Override
    public boolean isEmptyByGroupId(Long id) {
        return timetableRepository.findByAndGroup_Id(id).isEmpty();
    }

    @Override
    public boolean isEmptyByTeacherIdAndDayAndLesson(Long id, DayOfWeek day, int lesson, Long teacherId) {
        if(timetableRepository.findByAndDayOfWeekAndLessonAndTeacher_Id(day, lesson, teacherId).isEmpty()) {
            return true;
        } else {
            TimetableEntity timetableEntity = timetableRepository.findByAndDayOfWeekAndLessonAndTeacher_Id(day, lesson, teacherId).get();
            if (timetableEntity.getId().equals(id)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public TimetableEntity createTimetable(TimetableDTO timetableDTO) {
        TimetableEntity timetableEntity = new TimetableEntity(timetableDTO);
        timetableEntity.setGroup(groupRepository.findGroupEntityById(timetableDTO.getGroupId()));
        timetableEntity.setSubject(subjectRepository.findSubjectEntityById(timetableDTO.getSubjectId()));
        timetableEntity.setTeacher(teacherRepository.findTeacherEntityById(timetableDTO.getTeacherId()));
        return timetableRepository.save(timetableEntity);
    }

    @Override
    public TimetableEntity updateTimetable(Long id, TimetableDTO timetableDTO) {

        TimetableEntity timetableEntity = timetableRepository.getById(id);
        timetableEntity.fromTimetableDTO(timetableDTO);
        timetableEntity.setGroup(groupRepository.findGroupEntityById(timetableDTO.getGroupId()));
        timetableEntity.setSubject(subjectRepository.findSubjectEntityById(timetableDTO.getSubjectId()));
        timetableEntity.setTeacher(teacherRepository.findTeacherEntityById(timetableDTO.getTeacherId()));
        return timetableRepository.save(timetableEntity);
    }

    @Override
    public List<TimetableDTO> getAllTimetablesByGroupId(Long id) {
        return  timetableRepository.findAllByGroup_Id(id)
                .stream()
                .map(TimetableDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TimetableDTO> getAllTimetablesByTeacherId(Long id) {
        return  timetableRepository.findAllByTeacher_Id(id)
                .stream()
                .map(TimetableDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllTimetablesByGroupId(Long id) {
        timetableRepository.deleteAllByGroup_Id(id);
    }
}
