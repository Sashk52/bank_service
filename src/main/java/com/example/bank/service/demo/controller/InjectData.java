package com.example.bank.service.demo.controller;

import com.example.bank.service.demo.entity.Role;
import com.example.bank.service.demo.entity.User;
import com.example.bank.service.demo.service.RoleService;
import com.example.bank.service.demo.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final RoleService roleService;
    private final UserService userService;

    public InjectData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);

        User user = new User();
        user.setName("adminUser");
        user.setDateOfBirth(LocalDate.of(2021, 3, 1));
        user.setPhoneNumber("809755555");
        user.setPassword("1234");
        user.setRoles(Set.of(roleAdmin));
        userService.save(user);

        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);

        User customUser = new User();
        customUser.setName("customUser");
        customUser.setDateOfBirth(LocalDate.of(2021, 2, 1));
        customUser.setPhoneNumber("809744444");
        customUser.setPassword("1111");
        customUser.setRoles(Set.of(roleUser));
        userService.save(customUser);
    }
}
