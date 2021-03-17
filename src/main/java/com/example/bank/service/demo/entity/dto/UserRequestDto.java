package com.example.bank.service.demo.entity.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String password;
}
