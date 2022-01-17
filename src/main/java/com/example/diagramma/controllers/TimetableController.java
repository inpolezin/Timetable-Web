package com.example.diagramma.controllers;

import com.example.diagramma.dto.TimetableDTO;
import com.example.diagramma.pojos.TimetablePOJO;
import com.example.diagramma.services.GroupService;
import com.example.diagramma.services.SubjectService;
import com.example.diagramma.services.TeacherService;
import com.example.diagramma.services.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/timetables")
@RequiredArgsConstructor
public class TimetableController {
    private final GroupService groupService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final TimetableService timetableService;

    @GetMapping("/new")
    public String showCreateTimetableForm(Model model) {
        String[] lessons = new String[]{"1","2","3","4","5"};
        model.addAttribute("groups", groupService.getAllGroupDTO());
        model.addAttribute("subjects", subjectService.getAllSubjectDTO());
        model.addAttribute("teachers", teacherService.getAllTeacherDTO());
        model.addAttribute("timetable", new TimetableDTO());
        model.addAttribute("lessons", lessons);
        return "timetables/new";
    }

    @GetMapping("/{id}/edit")
    public String showEditTimetableForm(@PathVariable("id") Long id, Model model) {
        String[] lessons = new String[]{"1","2","3","4","5"};
        model.addAttribute("selectedGroup", groupService.getGroupById(id));
        model.addAttribute("groups", groupService.getAllGroupDTO());
        model.addAttribute("timetables", timetableService.getAllTimetablesByGroupId(id));
        model.addAttribute("subjects", subjectService.getAllSubjectDTO());
        model.addAttribute("teachers", teacherService.getAllTeacherDTO());
        model.addAttribute("timetable", new TimetableDTO());
        model.addAttribute("lessons", lessons);
        return "timetables/edit";
    }

    @GetMapping("/{id}/student")
    public String showTimetableForStudent(@PathVariable("id") Long id, Model model) {
        String[] lessons = new String[]{"1","2","3","4","5"};
        model.addAttribute("selectedGroup", groupService.getGroupById(id));
        model.addAttribute("groups", groupService.getAllGroupDTO());
        model.addAttribute("timetables", timetableService.getAllTimetablesByGroupId(id));
        model.addAttribute("subjects", subjectService.getAllSubjectDTO());
        model.addAttribute("teachers", teacherService.getAllTeacherDTO());
        model.addAttribute("timetable", new TimetableDTO());
        model.addAttribute("lessons", lessons);
        return "students/timetable";
    }

    @GetMapping("/{id}/teacher")
    public String showTimetableForTeacher(@PathVariable("id") Long id, Model model) {
        String[] lessons = new String[]{"1","2","3","4","5"};
        model.addAttribute("selectedTeacher", teacherService.getTeacherById(id));
        model.addAttribute("groups", groupService.getAllGroupDTO());
        model.addAttribute("timetables", timetableService.getAllTimetablesByTeacherId(id));
        model.addAttribute("subjects", subjectService.getAllSubjectDTO());
        model.addAttribute("teachers", teacherService.getAllTeacherDTO());
        model.addAttribute("timetable", new TimetableDTO());
        model.addAttribute("lessons", lessons);
        return "teachers/timetable";
    }

    @ResponseBody
    @PostMapping()
    public ResponseEntity<TimetableDTO> createTimetable(@ModelAttribute("timetable") TimetableDTO timetableDTO) {
        timetableService.createTimetable(timetableDTO);
        return new ResponseEntity<>(timetableDTO, HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping("/{id}")
    public ResponseEntity<TimetableDTO> updateTimetable(@ModelAttribute("timetable") TimetableDTO timetableDTO, @PathVariable("id") Long id) {
        timetableService.updateTimetable(id, timetableDTO);
        return new ResponseEntity<>(timetableDTO, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/{id}/checkTimetable")
    public ResponseEntity<TimetablePOJO> checkTimetableIsExist(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new TimetablePOJO(timetableService.isEmptyByGroupId(id), id), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/checkTeacher")
    public ResponseEntity<Boolean> checkTeachersFree(@ModelAttribute("timetable") TimetableDTO timetableDTO) {
        boolean response = timetableService.isEmptyByTeacherIdAndDayAndLesson(timetableDTO.getId(), timetableDTO.getDay(), timetableDTO.getLesson(), timetableDTO.getTeacherId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
