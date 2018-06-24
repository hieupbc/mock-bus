package com.example.mockbus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/dashboard");
        return modelAndView;
    }

}
