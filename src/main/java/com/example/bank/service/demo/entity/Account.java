package com.example.bank.service.demo.entity;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", unique = true)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;
    private double balance;
    @Column(name = "is_active")
    private boolean isActive; // set false after PATCH operation
    @ManyToOne
    @ToString.Exclude
    private User user;


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0){
            throw new RuntimeException("Negative banance after transaction!");
        }
        this.balance = balance;
    }
}

