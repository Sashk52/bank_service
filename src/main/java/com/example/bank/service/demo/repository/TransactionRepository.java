package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.Account;
import com.example.bank.service.demo.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "from Transaction t join fetch t.fromAccount account_from "
            + "join fetch t.toAccount account_to "
            + "where account_from = ?1 or account_to =?1")
    List<Transaction> getAllTransactionByAccount(Account account, Pageable pageable);
}
