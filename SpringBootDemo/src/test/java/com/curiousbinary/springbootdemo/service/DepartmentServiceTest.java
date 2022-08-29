package com.curiousbinary.springbootdemo.service;

import com.curiousbinary.springbootdemo.error.DepartmentNotFoundException;
import com.curiousbinary.springbootdemo.model.Department;
import com.curiousbinary.springbootdemo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("IT Block")
                .departmentCode("101")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(Optional.ofNullable(department));
        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("departmentService.getDepartment")
    public void whenValidDepartmentID_thenDepartmentShouldFound() throws DepartmentNotFoundException {
        Long deptId = 1L;

        Department found = departmentService.getDepartment(deptId);

        assertEquals(deptId, found.getDepartmentId());
    }

    @Test
    @DisplayName("departmentService.getDepartmentByName")
    public void whenValidDepartmentName_thenDepartmentNameShouldFound() throws DepartmentNotFoundException {
        String departmentName = "IT";

        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}