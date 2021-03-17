package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Currency;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountNumber;
    private Currency currency;
    private BigDecimal balance;
    private Long userId;
}
