package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.User;
import com.example.bank.service.demo.entity.dto.UserRequestDto;
import com.example.bank.service.demo.entity.dto.UserResponseDto;
import com.example.bank.service.demo.service.UserMapper;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    @Override
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth().toString())
                .build();
    }
}
