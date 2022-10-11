package com.curiousbinary.graphqldemo.service;

import com.curiousbinary.graphqldemo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    List<Department> createDepartment(List<Department> departmentList);

    List<Department> getDepartmentList();
}
