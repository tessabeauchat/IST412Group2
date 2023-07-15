package com.example.ist412project.service;
/**
 * author: tessa
 */

import com.example.ist412project.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    /**
     * This method gets all employees stored in the employee database
     * @return list of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * this method saves a new employee into the employee database
     * @param employee all data related to a complete employee
     */
    void saveEmployee(Employee employee);

    /**
     * finds employee in employee database using employee id
     * @param eid
     * @return searched employee
     */
    Employee getEmployeeByID(long eid);

    /**
     * delete employee from employee database
     * @param eid
     */
    void deleteEmployeeByID(long eid);

    /**
     * sort employee information to be previewed
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @param sortDirection
     * @return sorted employee information
     */
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
