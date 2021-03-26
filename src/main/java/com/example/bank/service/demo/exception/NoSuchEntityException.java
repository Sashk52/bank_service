package com.example.bank.service.demo.exception;

public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException(String message) {
        super(message);
    }
}
