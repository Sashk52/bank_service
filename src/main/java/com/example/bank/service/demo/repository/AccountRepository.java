package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> getByAccountNumber(String accountNumber);

    @Override
    List<Account> findAll();
}
