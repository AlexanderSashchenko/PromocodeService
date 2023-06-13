package com.example.promocodeService.service;

import com.example.promocodeService.model.User;
import com.example.promocodeService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser() {
        return userRepository.saveAndFlush(new User());
    }

    public User getById(Long userId) {
        return userRepository.getReferenceById(userId);
    }
}
