package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account getById(Long id);

    Account getByAccountNumber(String accountNumber);

    void delete(Account account);

    List<Account> getAllAccountsByPhoneNumber(String phoneNumber);

    List<Account> getAllAccountsByUserId(Long id);
}
