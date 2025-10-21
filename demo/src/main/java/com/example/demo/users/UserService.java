package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;



    // Create new user
    public Users saveUser(String username, String rawPassword, String role) {
        Users user = new Users();
        user.setUsername(username);
//
        user.setRole(role);
        return userRepository.save(user);
    }

    // Find user by username
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

