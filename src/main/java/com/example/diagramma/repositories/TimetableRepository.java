package com.example.diagramma.repositories;

import com.example.diagramma.entities.DayOfWeek;
import com.example.diagramma.entities.TimetableEntity;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
    List<TimetableEntity> findByAndGroup_Id(Long id);
    List<TimetableEntity> findAllByGroup_Id(Long id);
    List<TimetableEntity> findAllByTeacher_Id(Long id);
    Optional<TimetableEntity> findByAndDayOfWeekAndLessonAndTeacher_Id(DayOfWeek day, int lesson, Long teacherId);
    void deleteAllByGroup_Id(Long id);
}
