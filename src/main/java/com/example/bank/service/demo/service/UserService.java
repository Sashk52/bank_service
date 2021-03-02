package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.User;

public interface UserService {
    User save(User user);

    User update(User user);

    void delete(User user);

    User getById(Long id);

    User getByPhoneNumber(String phoneNumber);
}
