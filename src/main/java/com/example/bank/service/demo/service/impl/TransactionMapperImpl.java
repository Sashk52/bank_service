package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Transaction;
import com.example.bank.service.demo.entity.dto.TransactionResponseDto;
import com.example.bank.service.demo.service.TransactionMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public TransactionResponseDto toDto(Transaction transaction) {
        return TransactionResponseDto.builder()
                .id(transaction.getId())
                .fromAccount(transaction.getFromAccount().toString())
                .toAccount(transaction.getToAccount().toString())
                .amount(transaction.getAmount().toString())
                .dateTime(transaction.getDateTime().toString())
                .type(transaction.getType().toString())
                .build();
    }
}
