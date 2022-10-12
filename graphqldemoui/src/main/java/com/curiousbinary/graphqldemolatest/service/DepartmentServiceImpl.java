package com.curiousbinary.graphqldemolatest.service;

import com.curiousbinary.graphqldemolatest.entity.Department;
import com.curiousbinary.graphqldemolatest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> createDepartment(List<Department> departmentList) {
        return departmentRepository.saveAll(departmentList);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Iterable<Department> getDepartments(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }
}
