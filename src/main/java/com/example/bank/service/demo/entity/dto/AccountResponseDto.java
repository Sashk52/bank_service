package com.example.bank.service.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto {
    private Long userId;
    private Long id;
    private String accountNumber;
    private String currency;
    private String balance;
    private boolean isActive;
}
