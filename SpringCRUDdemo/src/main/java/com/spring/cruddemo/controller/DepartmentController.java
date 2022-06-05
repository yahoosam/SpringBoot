package com.spring.cruddemo.controller;

import com.spring.cruddemo.entity.Department;
import com.spring.cruddemo.error.DepartmentNotFoundException;
import com.spring.cruddemo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/createdepartment")
    public Department createDepartment(@Valid @RequestBody Department department) throws DepartmentNotFoundException {
        LOGGER.info("Inside createDepartment of DepartmentController");
        return departmentService.createDepartment(department);
    }

    @GetMapping("/readdepartments")
    public List<Department> readDepartments() throws DepartmentNotFoundException {
        LOGGER.info("Inside readDepartments of DepartmentController");
        return departmentService.readDepartments();
    }

    @GetMapping("/readdepartment/{departmentid}")
    public Department readDepartment(@PathVariable("departmentid") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside readDepartment of DepartmentController");
        return departmentService.readDepartment(departmentId);
    }

    @DeleteMapping("/deletedepartment/{departmentid}")
    public String deleteDepartment(@PathVariable("departmentid") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside deleteDepartment of DepartmentController");
        departmentService.deleteDepartment(departmentId);
        return "Department Deleted Successfully...";
    }

    @PutMapping("/updatedepartment/{departmentid}")
    public Department updateDepartment(@PathVariable("departmentid") Long departmentId,
                                       @RequestBody Department department) throws DepartmentNotFoundException {
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/getdepartment/name/{name}")
    public Department getDepartment(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDepartment of DepartmentController");
        return departmentService.getDepartmentByName(departmentName);
        //Testing JPQL and NSQL
        //return departmentService.getDepartmentByCode(departmentName);
    }
}
