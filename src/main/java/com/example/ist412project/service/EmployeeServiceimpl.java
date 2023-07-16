package com.example.ist412project.service;

import com.example.ist412project.model.Employee;
import com.example.ist412project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceimpl implements EmployeeService{
    /**
     * Connect to employee repository
     */
    @Autowired
        private EmployeeRepository employeeRepository;

    /**
     * Get and display all data from employee repository
     * @return all employee data in list form
     */
    @Override
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

    /**
     * save employee data
     * @param employee all data related to a complete employee
     */
    @Override
        public void saveEmployee(Employee employee) { this.employeeRepository.save(employee);
        }

    /**
     * Get employee infomration using PK input of employee id to search database
     * @param eid
     * @return
     */
    @Override
        public Employee getEmployeeByID(long eid) {
            Optional<Employee> optional = employeeRepository.findById(eid);
            Employee employee = null;
            if (optional.isPresent()){
                employee = optional.get();
            }
            else{
                throw new RuntimeException(" Employee not found for id : :" + eid);
            }
            return employee;
        }

    /**
     * Delete employee from repository using PK employee id to search database
     * @param eid
     */
    @Override
        public void deleteEmployeeByID(long eid) { this.employeeRepository.deleteById(eid);

        }

    /**
     * Display information from data repository formatted
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @param sortDirection
     * @return
     */
        @Override
        public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
            Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                    Sort.by(sortField).descending();

            Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
            return this.employeeRepository.findAll(pageable);
        }
}
