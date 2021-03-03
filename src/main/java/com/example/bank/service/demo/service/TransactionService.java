package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void transfer(Account toAccount, Account fromAccount, BigDecimal amount);

    List<Transaction> getAllByAccount(int page, int size, Account account);
}
