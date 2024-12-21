package com.microservice.departmentService.controller;

import com.microservice.departmentService.model.Department;
import com.microservice.departmentService.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        logger.info("department added :{}",department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        logger.info("getAllDepartments :{}",departmentRepository.findAll());
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        logger.info("getDepartmentById :{}",departmentRepository.findById(id));
        return departmentRepository.findById(id);
    }
}
