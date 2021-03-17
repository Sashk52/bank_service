package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponseDto {
    private Long id;
    private Account fromAccount;
    private Account toAccount;
    private LocalDateTime dateTime;
    private BigDecimal amount;
    private Transaction.Type type;
}
