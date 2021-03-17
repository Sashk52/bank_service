package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.dto.AccountRequestDto;
import com.example.bank.service.demo.entity.dto.AccountResponseDto;
import com.example.bank.service.demo.service.AccountMapper;
import com.example.bank.service.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapperImpl implements AccountMapper {
    private final UserService userService;

    @Override
    public Account toEntity(AccountRequestDto dto) {
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setUser(userService.getById(dto.getUserId()));
        account.setBalance(dto.getBalance());
        account.setCurrency(dto.getCurrency());
        return account;
    }

    @Override
    public AccountResponseDto toDto(Account account) {
        return AccountResponseDto.builder()
                .accountNumber(account.getAccountNumber())
                .currency(account.getCurrency())
                .balance(account.getBalance())
                .build();
    }
}
