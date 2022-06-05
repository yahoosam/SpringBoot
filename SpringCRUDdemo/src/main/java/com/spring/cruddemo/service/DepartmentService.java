package com.spring.cruddemo.service;

import com.spring.cruddemo.entity.Department;
import com.spring.cruddemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department createDepartment(Department department) throws DepartmentNotFoundException;

    public List<Department> readDepartments() throws DepartmentNotFoundException;

    public Department readDepartment(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;

    Department getDepartmentByCode(String departmentCode) throws DepartmentNotFoundException;
}
