package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import java.util.Optional;

public interface AccountService {
    Account add(Account account);

    Account update(Account account);

    Account getById(Long id);

    void delete(Account account);

    Account getByAccountNumber(String accountNumber);
}
