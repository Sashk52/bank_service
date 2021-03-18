package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Currency;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountNumber;
    private String currency;
    private Double balance;
    private Long userId;
}
