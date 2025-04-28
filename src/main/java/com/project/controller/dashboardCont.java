package com.project.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardCont {
	@GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Get the currently authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // This will give the username (like 'admin' or 'faculty1')
        
        model.addAttribute("username", username);
        
        // Example: Add an announcement
        String announcement = "📢 Reminder: Submit your annual report before May 10th!";
        model.addAttribute("announcement", announcement);
        
        return "dashboard";
    }

}

