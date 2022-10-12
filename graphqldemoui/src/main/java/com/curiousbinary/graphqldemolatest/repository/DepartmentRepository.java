package com.curiousbinary.graphqldemolatest.repository;

import com.curiousbinary.graphqldemolatest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Iterable<Department> findByDepartmentCode(String departmentCode);
}
