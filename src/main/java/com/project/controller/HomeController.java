package com.project.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    

    @GetMapping("/registration") // Handles /registration page
    public String registration() {
        return "registration"; // This loads registration.html
    }

    @GetMapping("/eventsActivities") // Handles Events & Activities page
    public String eventsActivities() {
        return "eventsActivities"; // This loads events-activities.html
    }
   
    
    @GetMapping("/viewdata") // Handles Events & Activities page
    public String viewdata() {
        return "viewdata"; // This loads events-activities.html
    }
    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Must match "home.html" in templates folder
    }
    
}
