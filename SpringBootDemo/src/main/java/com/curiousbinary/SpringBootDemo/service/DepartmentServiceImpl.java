package com.curiousbinary.SpringBootDemo.service;

import com.curiousbinary.SpringBootDemo.model.Department;
import com.curiousbinary.SpringBootDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Override
    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDepartment(Department department, Long deptId) {
        Department depDB = departmentRepository.findById(deptId).get();

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(depDB);
    }

}
