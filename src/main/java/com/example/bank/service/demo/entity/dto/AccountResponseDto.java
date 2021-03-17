package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Currency;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto {
    private Long id;
    private String accountNumber;
    private Currency currency;
    private BigDecimal balance;
    private boolean isActive;
}
