package com.curiousbinary.springbootdemo.controller;

import com.curiousbinary.springbootdemo.error.DepartmentAlreadyExistException;
import com.curiousbinary.springbootdemo.error.DepartmentNotFoundException;
import com.curiousbinary.springbootdemo.model.Department;
import com.curiousbinary.springbootdemo.service.DepartmentService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setup() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("IT Block")
                .departmentCode("101")
                .departmentId(1L)
                .build();
    }

    @Test
    @DisplayName("controller.savedepartment")
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("IT Block")
                .departmentCode("101")
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(post("/savedepartment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"departmentName\": \"IT\",\n" +
                                "\t\"departmentAddress\": \"IT Block\",\n" +
                                "\"departmentCode\": \"101\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("controller.getdepartment")
    void getDepartment() throws Exception {

        Mockito.when(departmentService.getDepartment(1L))
                .thenReturn(department);

        mockMvc.perform(get("/getdepartment/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}