package com.spring.cruddemo.repository;

import com.spring.cruddemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CSC")
                .departmentAddress("CSC Block")
                .departmentCode("201")
                .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("findById Unit Testing")
    void whenFindById_thenReturnDepartment() {
        Long id = 1L;
        String departmentName = "CSC";

        Department found = departmentRepository.findById(id).get();
        assertEquals(departmentName, found.getDepartmentName());
    }
}