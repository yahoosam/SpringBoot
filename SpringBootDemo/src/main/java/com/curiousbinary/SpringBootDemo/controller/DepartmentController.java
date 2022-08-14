package com.curiousbinary.SpringBootDemo.controller;

import com.curiousbinary.SpringBootDemo.model.Department;
import com.curiousbinary.SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/savedepartment")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getdepartmentlist")
    public List<Department> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

    @GetMapping("/getdepartment/{id}")
    public Department getDepartment(@PathVariable("id") Long deptId) {
        return departmentService.getDepartment(deptId);
    }

    @PutMapping("/updatedepartment/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long deptId) {
        return departmentService.updateDepartment(department, deptId);
    }

    @DeleteMapping("/deletedepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Long deptId) {
        departmentService.deleteDepartment(deptId);
    }

}
