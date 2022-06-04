package com.spring.cruddemo.service;

import com.spring.cruddemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department createDepartment(Department department);

    public List<Department> readDepartments();

    public Department readDepartment(Long departmentId);

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);
}
