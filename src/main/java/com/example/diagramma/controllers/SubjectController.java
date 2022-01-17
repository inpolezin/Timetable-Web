package com.example.diagramma.controllers;

import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.pojos.TimetablePOJO;
import com.example.diagramma.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping()
    public String showAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjectDTO());
        return "subjects/all";
    }

    @GetMapping("new")
    public String showCreateSubjectForm(Model model) {
        model.addAttribute("subject", new SubjectDTO());
        return "subjects/new";
    }

    @PostMapping()
    public String createSubject(@ModelAttribute("subject") SubjectDTO subjectDTO) {
        subjectService.createSubject(subjectDTO);
        return "redirect:/subjects";
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable("id") Long id){
        try {
            subjectService.deleteSubjectById(id);
            return new ResponseEntity<>("/subjects", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка. Данный предмет необходимо убрать из расписания для удаления", HttpStatus.OK);
        }
    }
}