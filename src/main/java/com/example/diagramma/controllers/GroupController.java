package com.example.diagramma.controllers;

import com.example.diagramma.dto.GroupDTO;
import com.example.diagramma.dto.SubjectDTO;
import com.example.diagramma.services.GroupService;
import com.example.diagramma.services.SubjectService;
import com.example.diagramma.services.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final TimetableService timetableService;

    @GetMapping()
    public String showAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroupDTO());
        return "groups/all";
    }

    @GetMapping("new")
    public String showCreateGroupForm(Model model) {
        model.addAttribute("group", new GroupDTO());
        return "groups/new";
    }

    @PostMapping()
    public String createGroup(@ModelAttribute("group") GroupDTO groupDTO) {
        groupService.createGroup(groupDTO);
        return "redirect:/groups";
    }


    @Transactional
    @DeleteMapping("/{id}")
    public String deleteGroupById(@PathVariable("id") Long id){
        timetableService.deleteAllTimetablesByGroupId(id);
        groupService.deleteGroupById(id);
        return "redirect:/groups";

    }
}