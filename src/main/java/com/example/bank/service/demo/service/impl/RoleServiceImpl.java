package com.example.bank.service.demo.service.impl;

import com.example.bank.service.demo.entity.Role;
import com.example.bank.service.demo.repository.RoleRepository;
import com.example.bank.service.demo.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getByRoleName(Role.RoleName.valueOf(name)).get();
    }
}
