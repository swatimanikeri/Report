package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.entity.Users;
import com.project.repository.UserRepository;

@Service

//logic for storing the created Users-data 

public class UserService {
	@Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder; // Encrypts passwords

    public Users createUser(String username, String password, String role) {
        Users user = new Users();
        user.setUsername(username);
    //    user.setPassword(passwordEncoder.encode(password)); // Encrypt password
        user.setRole(role);
        return userRepository.save(user);
    }
}
