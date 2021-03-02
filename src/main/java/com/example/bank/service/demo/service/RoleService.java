package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
