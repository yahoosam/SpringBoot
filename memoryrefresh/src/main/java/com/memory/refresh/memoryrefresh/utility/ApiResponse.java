package com.memory.refresh.memoryrefresh.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
    private Map<String, String> details;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.details = new HashMap<>();
    }
}
