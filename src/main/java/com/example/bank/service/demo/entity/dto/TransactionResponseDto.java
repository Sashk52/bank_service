package com.example.bank.service.demo.entity.dto;

import com.example.bank.service.demo.entity.Account;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
