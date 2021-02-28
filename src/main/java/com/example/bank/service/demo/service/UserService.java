package com.example.bank.service.demo.service;

import com.example.bank.service.demo.entity.User;
import com.example.bank.service.demo.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getById(Long id) {
        return userRepository.get().getById(id);
    }
    public User findByPhoneNumber(int phoneNumber) {

    }
}
