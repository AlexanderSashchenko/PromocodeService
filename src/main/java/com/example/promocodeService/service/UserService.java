package com.example.promocodeService.service;

import com.example.promocodeService.model.User;
import com.example.promocodeService.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> saveUser() {
        return userRepository.save(new User());
    }
}
