package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.repository.AccountRepository;
import com.example.bank.service.demo.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getByAccountNumber(String accountNumber) {
        return accountRepository.getByAccountNumber(accountNumber).get();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
