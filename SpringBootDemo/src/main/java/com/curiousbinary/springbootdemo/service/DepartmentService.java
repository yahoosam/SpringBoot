package com.curiousbinary.springbootdemo.service;

import com.curiousbinary.springbootdemo.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartment(Long deptId);

    void deleteDepartment(Long deptId);

    Department updateDepartment(Department department, Long deptId);

    Department getDepartmentByName(String deptName);

    Department getFilteredresults(String deptName);
}
