package com.curiousbinary.graphqldemolatest.controller;

import com.curiousbinary.graphqldemolatest.entity.Department;
import com.curiousbinary.graphqldemolatest.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createdepartment")
    public List<Department> createDepartment(@RequestBody List<Department> departmentList) {
        return departmentService.createDepartment(departmentList);
    }

    @QueryMapping()
    Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @QueryMapping()
    Department getDepartment(@Argument Long id) {
        return departmentService.getDepartment(id);
    }

    @QueryMapping()
    Iterable<Department> getDepartments(@Argument String departmentCode) {
        return departmentService.getDepartments(departmentCode);
    }
}
