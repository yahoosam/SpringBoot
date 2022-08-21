package com.curiousbinary.springbootdemo.repository;

import com.curiousbinary.springbootdemo.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("IT Block")
                .departmentCode("101")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("departmentRepository.findById")
    public void whenFindById_thenReturnDepartment() {
        Long id = 1L;
        String departmentName = "IT";

        Department department = departmentRepository.findById(id).get();
        assertEquals(departmentName, department.getDepartmentName());
    }
}