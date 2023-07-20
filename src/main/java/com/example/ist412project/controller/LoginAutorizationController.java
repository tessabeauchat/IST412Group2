//https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
package com.example.ist412project.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginAutorizationController {
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
