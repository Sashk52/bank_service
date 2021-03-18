package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.User;
import com.example.bank.service.demo.entity.dto.UserRequestDto;
import com.example.bank.service.demo.entity.dto.UserResponseDto;

public interface UserMapper {
    User toEntity(UserRequestDto dto);

    UserResponseDto toDto(User user);
}
