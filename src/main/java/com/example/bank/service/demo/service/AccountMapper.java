package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.dto.AccountRequestDto;
import com.example.bank.service.demo.entity.dto.AccountResponseDto;

public interface AccountMapper {
    Account toEntity(AccountRequestDto dto);

    AccountResponseDto toDto(Account account);
}
