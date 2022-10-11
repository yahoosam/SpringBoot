package com.curiousbinary.graphqldemo.service;

import org.springframework.http.ResponseEntity;

public interface DepartmentGraphQLService {
    ResponseEntity<Object> getDepartmentList(String query);

    ResponseEntity<Object> getDepartment(String query);
}
