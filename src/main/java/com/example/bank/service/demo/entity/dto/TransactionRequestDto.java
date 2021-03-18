package com.example.bank.service.demo.entity.dto;

import lombok.Data;

@Data
public class TransactionRequestDto {
    private String fromAccount;
    private String toAccount;
    private Double amount;
}
