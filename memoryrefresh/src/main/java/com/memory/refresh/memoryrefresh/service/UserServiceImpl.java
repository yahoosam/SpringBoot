package com.memory.refresh.memoryrefresh.service;

import com.memory.refresh.memoryrefresh.dto.UserRequestDto;
import com.memory.refresh.memoryrefresh.dto.UserResponseDto;
import com.memory.refresh.memoryrefresh.entity.User;
import com.memory.refresh.memoryrefresh.exception.EmailAlreadyExistsException;
import com.memory.refresh.memoryrefresh.exception.InvalidDataException;
import com.memory.refresh.memoryrefresh.exception.ResourceNotFoundException;
import com.memory.refresh.memoryrefresh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user =  userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User with id " + id + " not found"));
        return convertToDto(user);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if(userRequestDto.getFirstName().isBlank() || userRequestDto.getLastName().isBlank()
                || userRequestDto.getEmail().isBlank() || userRequestDto.getPassword().isBlank()) {
            throw new InvalidDataException("Name / Email / Password should not be blank");
        }
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already taken " + userRequestDto.getEmail());
        }
        User user = convertToEntity(userRequestDto);
        user.setCreatedAt(java.time.LocalDateTime.now());
        return convertToDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        if(userRequestDto.getFirstName().isBlank() || userRequestDto.getLastName().isBlank()
                || userRequestDto.getEmail().isBlank() || userRequestDto.getPassword().isBlank()) {
            throw new InvalidDataException("Name / Email / Password should not be blank");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already taken " + userRequestDto.getEmail());
        }

        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setUpdatedAt(java.time.LocalDateTime.now());
        return convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userRepository.deleteById(id);
    }

    private User convertToEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    private UserResponseDto convertToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setCreatedAt(user.getCreatedAt());
        userResponseDto.setUpdatedAt(user.getUpdatedAt());
        userResponseDto.setVersion(user.getVersion());
        userResponseDto.setResponseDate(java.time.LocalDateTime.now());  // Date field added to response
        return userResponseDto;
    }
}
