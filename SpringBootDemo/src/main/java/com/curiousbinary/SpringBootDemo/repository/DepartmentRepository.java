package com.curiousbinary.SpringBootDemo.repository;

import com.curiousbinary.SpringBootDemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
