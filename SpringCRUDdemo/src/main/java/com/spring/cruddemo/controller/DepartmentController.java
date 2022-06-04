package com.spring.cruddemo.controller;

import com.spring.cruddemo.entity.Department;
import com.spring.cruddemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createdepartment")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/readdepartments")
    public List<Department> readDepartments(){
        return departmentService.readDepartments();
    }

    @GetMapping("/readdepartment/{departmentid}")
    public Department readDepartment(@PathVariable("departmentid") Long departmentId){
        return departmentService.readDepartment(departmentId);
    }

    @DeleteMapping("/deletedepartment/{departmentid}")
    public String deleteDepartment(@PathVariable("departmentid") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "Department Deleted Successfully...";
    }

    @PutMapping("/updatedepartment/{departmentid}")
    public Department updateDepartment(@PathVariable("departmentid") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
}
