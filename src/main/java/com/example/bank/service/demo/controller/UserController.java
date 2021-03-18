package com.example.bank.service.demo.controller;

import com.example.bank.service.demo.entity.User;
import com.example.bank.service.demo.entity.dto.UserRequestDto;
import com.example.bank.service.demo.entity.dto.UserResponseDto;
import com.example.bank.service.demo.service.RoleService;
import com.example.bank.service.demo.service.UserMapper;
import com.example.bank.service.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleService roleService;

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        user.getRoles().add(roleService.getByName("USER"));
        return userMapper.toDto(userService.save(user));
    }

    @PutMapping("/{userId}")
    public UserResponseDto update(@RequestBody UserRequestDto userRequestDto,
                                  @PathVariable Long userId) {
        User user = userMapper.toEntity(userRequestDto);
        user.setId(userId);
        user.setRoles(userService.getById(userId).getRoles());
        return userMapper.toDto(userService.update(user));
    }

    @GetMapping("/{userId}")
    public UserResponseDto getById(@PathVariable Long userId) {
        return userMapper.toDto(userService.getById(userId));
    }

    @GetMapping("/by-phone")
    public UserResponseDto getByPhoneNumber(@RequestParam String phoneNumber) {
        return userMapper.toDto(userService.getByPhoneNumber(phoneNumber));
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable Long userId) {
        userService.delete(userService.getById(userId));
        return "User with id: " + userId + " was deleted!";
    }
}
