package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Currency;
import com.example.bank.service.demo.entity.dto.AccountRequestDto;
import com.example.bank.service.demo.entity.dto.AccountResponseDto;
import com.example.bank.service.demo.service.AccountMapper;
import com.example.bank.service.demo.service.UserService;
import java.math.BigDecimal;
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
        account.setBalance(BigDecimal.valueOf(dto.getBalance()));
        account.setCurrency(Currency.valueOf(dto.getCurrency()));
        return account;
    }

    @Override
    public AccountResponseDto toDto(Account account) {
        return AccountResponseDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .currency(account.getCurrency().toString())
                .balance(account.getBalance().toString())
                .isActive(account.isActive())
                .build();
    }
}
