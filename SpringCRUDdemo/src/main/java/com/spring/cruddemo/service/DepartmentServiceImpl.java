package com.spring.cruddemo.service;

import com.spring.cruddemo.entity.Department;
import com.spring.cruddemo.error.DepartmentNotFoundException;
import com.spring.cruddemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department createDepartment(Department department) throws DepartmentNotFoundException {

        Department deptDB = departmentRepository.save(department);
        if(deptDB == null){
            throw new DepartmentNotFoundException("Department Not Available!!");
        }
        return deptDB;
    }

    @Override
    public List<Department> readDepartments() throws DepartmentNotFoundException {

        List<Department> departmentList = departmentRepository.findAll();
        if(departmentList.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Available!!");
        }
        return departmentList;
    }

    @Override
    public Department readDepartment(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available!!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) throws DepartmentNotFoundException {

        try {
            departmentRepository.findById(departmentId).get();
        } catch (Exception e) {
            throw new DepartmentNotFoundException("Department Not Available!!");
        }

        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {

        Department deptDB = null;
        try {
            deptDB = departmentRepository.findById(departmentId).get();
        } catch (Exception e) {
            throw new DepartmentNotFoundException("Department Not Available!!");
        }

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            deptDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(deptDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {

        //Department department = departmentRepository.findByDepartmentName(departmentName);
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if(department == null){
            throw new DepartmentNotFoundException("Department Not Available!!");
        }
        return department;
    }

    @Override
    public Department getDepartmentByCode(String departmentCode) throws DepartmentNotFoundException {

        Department department = departmentRepository.findByDepartmentCodeJPQL(departmentCode);
        //Department department = departmentRepository.findByDepartmentCodeNSQL(departmentCode);

        if(department == null){
            throw new DepartmentNotFoundException("Department Not Available!!");
        }
        return department;
    }
}
