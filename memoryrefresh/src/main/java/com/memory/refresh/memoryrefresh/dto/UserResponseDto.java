package com.memory.refresh.memoryrefresh.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer version;
    private LocalDateTime responseDate; // Added date field that is not in DB
}
