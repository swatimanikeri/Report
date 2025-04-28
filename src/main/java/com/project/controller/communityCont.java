package com.project.controller;

import java.io.IOException;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;

import com.project.entity.CommunityServiceEntity;

import com.project.service.CommunityServicesSer;

@Controller
public class communityCont {
    
    @Autowired 
    private CommunityServicesSer communityServicesSer;

    @GetMapping("/Community")
    public void showSponsoredForm(Model model) {
	    Map<String, String> dynamicFields = communityServicesSer.loadDynamicFieldNamesOnly(); // use your bean here
	    model.addAttribute("dynamicJson", dynamicFields);
    }

    @PostMapping("/saveComm")
    public String submitForm(
        @RequestParam("activity") String activity,
        @RequestParam("date") String date,                     
        @RequestParam("resourseperson") String resourseperson,
        @RequestParam("audience") String audience,
        @RequestParam("dynamicFields") String dynamicFieldsJson,
        @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
    {
        System.out.println(date);
        communityServicesSer.savelogic(activity, date, resourseperson, audience, dynamicFieldsJson,image1,image2); // ✅ Correct Service method call
        return "redirect:/Community";
    }
    
    @GetMapping("/CommunityView")
    public String showFormData(Model model) {
        // Fetch all data from the database
        List<CommunityServiceEntity> formDataList = communityServicesSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "CommunityView";  // Return the page to display form data
    }
    @PostMapping("/community/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
    	communityServicesSer.deleteById(id);
        return "redirect:/CommunityView"; // Redirect to the display page
    }
}