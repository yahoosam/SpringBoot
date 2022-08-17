package com.curiousbinary.springbootdemo.service;

import com.curiousbinary.springbootdemo.error.DepartmentNotFoundException;
import com.curiousbinary.springbootdemo.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentList();

    Department getDepartment(Long deptId) throws DepartmentNotFoundException;

    void deleteDepartment(Long deptId) throws DepartmentNotFoundException;

    Department updateDepartment(Department department, Long deptId) throws DepartmentNotFoundException;

    Department getDepartmentByName(String deptName) throws DepartmentNotFoundException;

    Department getFilteredresults(String deptName) throws DepartmentNotFoundException;
}
