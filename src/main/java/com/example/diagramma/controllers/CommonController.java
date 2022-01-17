package com.example.diagramma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/start")
    public String showStartPage() {
        return "home";
    }

    @GetMapping("/admins")
    public String showAdminStartPage() {
        return "admins/index";
    }
}
