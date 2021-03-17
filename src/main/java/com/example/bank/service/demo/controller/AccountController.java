package com.example.bank.service.demo.controller;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.dto.AccountRequestDto;
import com.example.bank.service.demo.entity.dto.AccountResponseDto;
import com.example.bank.service.demo.entity.dto.TransactionRequestDto;
import com.example.bank.service.demo.entity.dto.TransactionResponseDto;
import com.example.bank.service.demo.service.AccountMapper;
import com.example.bank.service.demo.service.AccountService;
import com.example.bank.service.demo.service.TransactionMapper;
import com.example.bank.service.demo.service.TransactionService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final TransactionMapper transactionMapper;
    private final TransactionService transactionService;
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @PostMapping
    public AccountResponseDto create(@RequestBody AccountRequestDto accountRequestDto) {
        Account account = accountMapper.toEntity(accountRequestDto);
        account.setActive(true);
        return accountMapper.toDto(accountService.save(account));
    }

    @GetMapping("/by-phone")
    public AccountResponseDto getAllByPhoneNumber(@RequestParam String accountNumber) {
        return accountMapper.toDto(accountService.getByAccountNumber(accountNumber));
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam TransactionRequestDto requestDto) {
        transactionService.transfer(requestDto.getToAccount(),
                requestDto.getFromAccount(), requestDto.getAmount());
        return "Payment is successful!";
    }

    @GetMapping("/{accountNumber}")
    public BigDecimal getBalance(@PathVariable String accountNumber) {
        return accountService.getByAccountNumber(accountNumber).getBalance();
    }

    @GetMapping("/history/{accountNumber}")
    public List<TransactionResponseDto> getHistory(
            @PathVariable String accountNumber,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        return transactionService.getAllByAccount(page, limit,
                accountService.getByAccountNumber(accountNumber))
                .stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PatchMapping("/{accountNumber}")
    public void block(@PathVariable String accountNumber) {
        Account account = accountService.getByAccountNumber(accountNumber);
        account.setActive(false);
        accountService.save(account);
    }
}
