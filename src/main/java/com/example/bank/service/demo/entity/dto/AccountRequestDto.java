package com.example.bank.service.demo.entity.dto;

import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountNumber;
    private String currency;
    private Double balance;
    private Long userId;
}
