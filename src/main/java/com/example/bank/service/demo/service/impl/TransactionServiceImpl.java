package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Transaction;
import com.example.bank.service.demo.repository.TransactionRepository;
import com.example.bank.service.demo.service.AccountService;
import com.example.bank.service.demo.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Override
    public void save(Account toAccount, Account fromAccount, double amount) {
        Transaction transactionCredited = new Transaction();
        transactionCredited.setAmount(amount);
        transactionCredited.setDateTime(LocalDateTime.now());
        transactionCredited.setType(Transaction.Type.OUTCOMING);
        transactionCredited.setFromAccount(fromAccount);
        transactionCredited.setToAccount(toAccount);
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        accountService.add(fromAccount);
        transactionRepository.save(transactionCredited);

        Transaction transactionDebited = new Transaction();
        transactionDebited.setAmount(amount);
        transactionDebited.setDateTime(transactionCredited.getDateTime());
        transactionDebited.setType(Transaction.Type.INCOMING);
        transactionDebited.setFromAccount(fromAccount);
        transactionDebited.setToAccount(toAccount);
        toAccount.setBalance(toAccount.getBalance()+amount);
        accountService.add(toAccount);
        transactionRepository.save(transactionDebited);
    }

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllTransactionByAccount(account,pageable);
    }
}
