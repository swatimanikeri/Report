package com.project.controller;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.ReportService;

@Controller
public class ReportController {
//@Autowired
public ReportService service; 

//method for Home Page
    @GetMapping("/")
    public String homepage() {
        return "home"; 
    }

    @GetMapping("/about")
    public String aboutpage() {
        System.out.println("About page accessed");
        return "about"; 
    }
    @GetMapping("/AdminLogin")
    public String Adminloginpage() {
        System.out.println("Admin login accessed");
        return "AdminLogin"; 
    }
    
    /*
    @GetMapping("/faculty")
    public String facultypage() {
        System.out.println("regpage accessed");
        return "faculty"; 
    }
    @PostMapping("/savedata")
    public String formdata(@ModelAttribute ReportModel rm) {
       // System.out.println(rm.get); // Check if this prints the entered ID
        System.out.println(rm.getFull_Name());
       /* System.out.println(rm.getEmial_id());
        System.out.println(rm.getEmployee_id());
        System.out.println(rm.getPass());
        System.out.println(rm.getConfirm_pass());
      
        service.Savelogic(rm);
        return "redirect:/";
    }*/

   
}
