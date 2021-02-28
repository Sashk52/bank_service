package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
