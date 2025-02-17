package com.memory.refresh.memoryrefresh.service;

import com.memory.refresh.memoryrefresh.dto.UserRequestDto;
import com.memory.refresh.memoryrefresh.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    void deleteUser(Long id);
}
