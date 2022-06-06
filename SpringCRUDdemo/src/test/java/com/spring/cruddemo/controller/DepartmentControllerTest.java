package com.spring.cruddemo.controller;

import com.spring.cruddemo.entity.Department;
import com.spring.cruddemo.error.DepartmentNotFoundException;
import com.spring.cruddemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("CSC")
                .departmentAddress("CSC Block")
                .departmentCode("105")
                .departmentId(1L)
                .build();
    }

    @Test
    @DisplayName("createDepartment Unit Test")
    void createDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("CSC")
                .departmentAddress("CSC Block")
                .departmentCode("105")
                .build();

        Mockito.when(departmentService.createDepartment(inputdepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/createdepartment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\": \"CSC\",\n" +
                        "\t\"departmentAddress\": \"CSC Block\",\n" +
                        "    \"departmentCode\": \"105\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("readDepartment Unit Test")
    void readDepartment() throws Exception {
        Long id = 1L;

        Mockito.when(departmentService.readDepartment(id)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/readdepartment/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}