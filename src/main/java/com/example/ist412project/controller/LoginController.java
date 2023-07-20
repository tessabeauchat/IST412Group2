package com.example.ist412project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("employee_dashboard.html")
    public String employee_dashboard(){
        return "employee_dashboard";
    }
    @GetMapping("manager_dashboard.html")
    public String manager_dashboard(){
        return "manager_dashboard";
    }
}
