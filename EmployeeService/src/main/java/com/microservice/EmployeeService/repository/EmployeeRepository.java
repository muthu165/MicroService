package com.microservice.EmployeeService.repository;

import com.microservice.EmployeeService.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();


    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployee(){
        return employeeList;
    }

    public Employee getEmployeeById(Long id){
        return employeeList.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long id){
        return employeeList.stream()
                .filter(employee -> employee.departmentId().equals(id))
                .toList();
    }


}
