package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Transaction;
import com.example.bank.service.demo.entity.dto.TransactionResponseDto;

public interface TransactionMapper {
    TransactionResponseDto toDto(Transaction transaction);
}
