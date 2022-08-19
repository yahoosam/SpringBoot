package com.curiousbinary.springbootdemo.service;

import com.curiousbinary.springbootdemo.error.DepartmentAlreadyExistException;
import com.curiousbinary.springbootdemo.error.DepartmentNotFoundException;
import com.curiousbinary.springbootdemo.model.Department;
import com.curiousbinary.springbootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) throws DepartmentAlreadyExistException {
        Optional<Department> dept = departmentRepository.checkDepartment(department.getDepartmentCode(),
                department.getDepartmentName());

        if (dept.isPresent()) {
            throw new DepartmentAlreadyExistException("Department already present...");
        }
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available...");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> deparment = departmentRepository.findById(deptId);
        if (!deparment.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available...");
        }
        departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDepartment(Department department, Long deptId)
            throws DepartmentNotFoundException, DepartmentAlreadyExistException {
        Optional<Department> dept = departmentRepository.findById(deptId);
        if (!dept.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available...");
        }

        Optional<Department> dept2 = departmentRepository.checkDepartmentWithId(department.getDepartmentCode(),
                department.getDepartmentName(), deptId);

        if (dept2.isPresent()) {
            throw new DepartmentAlreadyExistException("Data already present...");
        }

        Department depDB = dept.get();

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

    @Override
    public Department getDepartmentByName(String deptName) throws DepartmentNotFoundException {
        //Optional<Department> department = departmentRepository.findByDepartmentName(deptName);
        Optional<Department> department = departmentRepository.findByDepartmentNameIgnoreCase(deptName);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available...");
        }
        return department.get();
    }

    @Override
    public Department getFilteredresults(String deptName) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findFilteredRecords(deptName);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available...");
        }
        return department.get();
    }

}
