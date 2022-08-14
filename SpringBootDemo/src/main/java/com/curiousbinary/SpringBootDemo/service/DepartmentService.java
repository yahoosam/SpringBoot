package com.curiousbinary.SpringBootDemo.service;

import com.curiousbinary.SpringBootDemo.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartment(Long deptId);

    void deleteDepartment(Long deptId);

    Department updateDepartment(Department department, Long deptId);
}
