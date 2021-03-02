package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Transaction;
import java.util.List;

public interface TransactionService {
    void save(Account toAccount, Account fromAccount, double amount);

    List<Transaction> getAllByAccount(int page, int size, Account account);
}
