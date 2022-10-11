package com.curiousbinary.graphqldemo.controller;

import com.curiousbinary.graphqldemo.entity.Department;
import com.curiousbinary.graphqldemo.service.DepartmentGraphQLService;
import com.curiousbinary.graphqldemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentGraphQLService departmentGraphQLService;

    @PostMapping("/create")
    public List<Department> createDepartment(@RequestBody List<Department> departmentList) {
        return departmentService.createDepartment(departmentList);
    }

    @GetMapping("/getall")
    public List<Department> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

    @PostMapping("/getallgraphql")
    public ResponseEntity<Object> getDepartmentListGraphQL(@RequestBody String query) {
        return departmentGraphQLService.getDepartmentList(query);
    }

    @PostMapping("/getdepartmentgraphql")
    public ResponseEntity<Object> getDepartmentGraphQL(@RequestBody String query) {
        return departmentGraphQLService.getDepartment(query);
    }
}
