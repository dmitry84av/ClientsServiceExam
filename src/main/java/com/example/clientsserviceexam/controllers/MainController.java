package com.example.clientsserviceexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String load() {
        return "redirect:clients";
        //return "redirect:companies";
    }
}
