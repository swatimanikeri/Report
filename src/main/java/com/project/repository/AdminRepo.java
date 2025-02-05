package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Users;

public interface AdminRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
	

}
