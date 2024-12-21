package com.microservice.EmployeeService.controller;

import com.microservice.EmployeeService.model.Employee;
import com.microservice.EmployeeService.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Attempting to add employee: {}", employee);
        Employee addedEmployee = employeeRepository.addEmployee(employee);
        if (addedEmployee != null) {
            logger.info("Employee added successfully: {}", addedEmployee);
        } else {
            logger.warn("Failed to add employee: {}", employee);
        }
        return addedEmployee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees...");
        List<Employee> employees = employeeRepository.getAllEmployee();
        logger.info("Employee list retrieved: {} employees found.", employees.size());
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        logger.info("Fetching employee with ID: {}", id);
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee != null) {
            logger.info("Employee retrieved: {}", employee);
        } else {
            logger.warn("No employee found with ID: {}", id);
        }
        return employee;
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        logger.info("Fetching employees for department ID: {}", departmentId);
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        logger.info("Employees retrieved: {} employees found for department ID {}", employees.size(), departmentId);
        return employees;
    }
}
