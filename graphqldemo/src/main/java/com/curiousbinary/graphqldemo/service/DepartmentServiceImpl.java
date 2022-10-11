package com.curiousbinary.graphqldemo.service;

import com.curiousbinary.graphqldemo.entity.Department;
import com.curiousbinary.graphqldemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> createDepartment(List<Department> departmentList) {
        return departmentRepository.saveAll(departmentList);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }
}
