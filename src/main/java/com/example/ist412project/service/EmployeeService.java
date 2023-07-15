package com.example.ist412project.service;

import com.example.ist412project.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeByID(long eid);
    void deleteEmployeeByID(long eid);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
