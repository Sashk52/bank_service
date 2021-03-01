package com.example.bank.service.demo.repository;

import com.example.bank.service.demo.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> getByRoleName(Role.RoleName name);
}
