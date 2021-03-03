package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account getById(Long id);

    void delete(Account account);

    Account getByAccountNumber(String accountNumber);

    List<Account> getAllAccounts();
}
