package com.example.ist412project.service;

import com.example.ist412project.model.Employee;
import com.example.ist412project.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceimplTest {
    @Autowired
    private EmployeeRepository repository;


    @Test
    void getAllEmployees() {
        List<Employee> items = repository.findAll();
        assertEquals(4, items.size());
    }

    @Test
    void getOneEmployeeByID() {
    }

    @Test
    void deleteEmployeeByID() {
    }

    @Test
    void findPaginated() {
    }
}