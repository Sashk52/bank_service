package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Account;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransactionRequestDto {
    private Account fromAccount;
    private Account toAccount;
    private BigDecimal amount;
}
