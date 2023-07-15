package com.example.ist412project.controller;

import com.example.ist412project.model.Employee;
import com.example.ist412project.repository.EmployeeRepository;
import com.example.ist412project.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/EmployeeList")
    public String viewEmployeePage(Model model)
    {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employee_list";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model)
    {
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("Employee", employee);
        return "new_Employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("Employee") Employee employee)
    {
        //save Employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/EmployeeList";
    }

    @RequestMapping(value = "/get/{eid}")
    public String getEmployeeId(@PathVariable("eid") Long eid, Model model)
    {
        Optional<Employee> findEmployeeId = employeeRepository.findById(eid);
        model.addAttribute("title", "Data Employee");
        model.addAttribute("Employee", findEmployeeId);
        log.info("getEmployeeId() : " + eid);
        return "redirect:/EmployeeList";
    }

    @GetMapping("/showEmployeeFormForUpdate/{eid}")
    public String showEmployeeFormForUpdate(@PathVariable(value = "eid") long eid, Model model)
    {
        //get Employee from the service
        Employee Employee = employeeService.getEmployeeByID(eid);
        //set Employee as a model attribute to pre-populate the form
        model.addAttribute("Employee", Employee);
        return "update_Employee";
    }

    @GetMapping("/deleteEmployee/{eid}")
    public String deleteEmployee(@PathVariable(value = "eid") long eid)
    {
        //call delete Employee method
        this.employeeService.deleteEmployeeByID(eid);
        return "redirect:/EmployeeList";
    }
}
