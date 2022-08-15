package com.curiousbinary.springbootdemo.controller;

import com.curiousbinary.springbootdemo.model.Department;
import com.curiousbinary.springbootdemo.service.DepartmentService;
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

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/savedepartment")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getdepartmentlist")
    public List<Department> getDepartmentList() {
        LOGGER.info("Inside getDepartmentList controller");
        return departmentService.getDepartmentList();
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartment(@PathVariable("id") Long deptId) {
        LOGGER.info("Inside getDepartment controller");
        return departmentService.getDepartment(deptId);
    }

    @PutMapping("/updatedepartment/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long deptId) {
        LOGGER.info("Inside updateDepartment controller");
        return departmentService.updateDepartment(department, deptId);
    }

    @DeleteMapping("/deletedepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Long deptId) {
        LOGGER.info("Inside deleteDepartment controller");
        departmentService.deleteDepartment(deptId);
    }

    @GetMapping("getdepartmentbyname/{name}")
    public Department getDepartmentByName(@PathVariable("name") String deptName) {
        LOGGER.info("Inside getDepartmentByName controller");
        return departmentService.getDepartmentByName(deptName);
    }

    @GetMapping("getfilteredrecords/{name}")
    public Department getFilteredResults(@PathVariable("name") String deptName) {
        LOGGER.info("Inside getFilteredResults controller");
        return departmentService.getFilteredresults(deptName);
    }

}
