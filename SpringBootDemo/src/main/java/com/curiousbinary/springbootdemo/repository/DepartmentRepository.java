package com.curiousbinary.springbootdemo.repository;

import com.curiousbinary.springbootdemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Optional <Department> findByDepartmentName(String departmentName);
    public Optional <Department> findByDepartmentNameIgnoreCase(String departmentName);

    @Query(value = "SELECT * from Department d where d.Department_Name = ?1", nativeQuery = true)
    public Optional <Department> findFilteredRecords(String deptName);
}
