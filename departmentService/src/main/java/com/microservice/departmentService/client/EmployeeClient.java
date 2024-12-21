package com.microservice.departmentService.client;

import com.microservice.departmentService.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@FeignClient(name="employee-service")
public interface EmployeeClient {
    @GetMapping("/employee/department/{departmentId}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable("departmentId") Long departmentId);

}
