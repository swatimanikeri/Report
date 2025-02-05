package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Users;
import com.project.repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepository;

    public Users findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

	
}