package com.example.ist412project.controller;

import com.example.ist412project.model.Employee;
import com.example.ist412project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeRestController {
    @Autowired
    EmployeeService emplyService;

    @RequestMapping(value = "/employee/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> courses = (List<Employee>) emplyService.getAllEmployees();
        if(courses.isEmpty())
        {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<List<Employee>>(courses, HttpStatus.OK);
        }
    }
}
