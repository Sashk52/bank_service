package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
