package com.example.bank.service.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponseDto {
    private Long id;
    private String fromAccount;
    private String toAccount;
    private String dateTime;
    private String amount;
    private String type;
}
