package com.example.activity_manager.service;

import com.example.activity_manager.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.activity_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Find user
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Login logic
    public User authenticate(String username, String rawPassword) {
        User user = findByUsername(username);

        if (!passwordEncoder.matches(rawPassword, user.getUserPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

}
