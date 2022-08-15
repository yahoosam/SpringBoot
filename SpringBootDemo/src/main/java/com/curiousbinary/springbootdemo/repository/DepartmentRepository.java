package com.curiousbinary.springbootdemo.repository;

import com.curiousbinary.springbootdemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    @Query(value = "SELECT * from Department d where d.Department_Name = ?1", nativeQuery = true)
    public Department findFilteredRecords(String deptName);
}
