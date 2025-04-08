package com.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.TechnicalEventEntity;
import com.project.service.TechnicalEventService;

@Controller
public class TechnicalEventCont {

    @Autowired 
    private TechnicalEventService technicalEventService; // ✅ Fixed variable name

    @GetMapping("/TechnicalEvent")
    public String TechPage(Authentication authtech) {
        return "TechnicalEvent";
    }

    @PostMapping("/saveTech")
    public String submitForm(
        @RequestParam("studentname") String studentname,
        @RequestParam("event") String event,                     
        @RequestParam("date") String date,
        @RequestParam("organisedby") String organisedby,
        @RequestParam("status") String status,
        @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
    {
        System.out.println(date);
        technicalEventService.savelogic(studentname, event, date, organisedby, status, image1,image2); // ✅ Call instance method
        return "redirect:/TechnicalEvent";
    }
    
    @GetMapping("/ViewTechnical")
    public String showFormData(Model model) {
        // Fetch all data from the database
        List<TechnicalEventEntity> formDataList = technicalEventService.getAllFormData(); // ✅ Fixed method name
        model.addAttribute("formDataList", formDataList);
        return "ViewTechnical";  // ✅ Fixed spelling mistake
    }
    
    @PostMapping("/technical/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
    	technicalEventService.deleteById(id);
        return "redirect:/ViewTechnical"; // Redirect to the display page
    }
    
}
