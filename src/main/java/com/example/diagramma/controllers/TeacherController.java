package com.example.diagramma.controllers;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.dto.TeacherDTO;
import com.example.diagramma.services.SubjectService;
import com.example.diagramma.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping()
    public String showAllTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacherDTO());
        return "teachers/all";
    }

    @GetMapping("new")
    public String showCreateTeacherForm(Model model) {
        model.addAttribute("teacher", new SubjectDTO());
        return "teachers/new";
    }

    @PostMapping()
    public String createTeacher(@ModelAttribute("teacher") TeacherDTO teacherDTO) {
        teacherService.createTeacher(teacherDTO);
        return "redirect:/teachers";
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") Long id){
        try {
            teacherService.deleteTeacherById(id);
            return new ResponseEntity<>("/teachers", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка. Данного преподавателя необходимо убрать из расписания для удаления", HttpStatus.OK);
        }
    }
}