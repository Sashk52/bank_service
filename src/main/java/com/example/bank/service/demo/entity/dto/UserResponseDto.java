package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Role;
import java.time.LocalDate;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Set<Role> roles;
}
