package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.UserModel;
import com.project.service.UserService;
@RestController
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
    private UserService userService;
 
	//method for creating users in Admin-Dashboard
    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserModel um) {
        userService.createUser(um.getUsername(), um.getPassword(), um.getRole());
        return ResponseEntity.ok("User created successfully!");
    }
}
