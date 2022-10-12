package com.curiousbinary.graphqldemolatest.service;

import com.curiousbinary.graphqldemolatest.entity.Department;

import java.util.List;

public interface DepartmentService {
    Iterable<Department> getAllDepartments();

    List<Department> createDepartment(List<Department> departmentList);

    Department getDepartment(Long id);

    Iterable<Department> getDepartments(String departmentCode);
}
