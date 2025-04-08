package com.project.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.AlumniContributionEntity;

import com.project.service.AlumniContributionSer;

@Controller
public class AlumniContributionCon {

	
	@Autowired 
	   private AlumniContributionSer  AlumniContributionSer;

	   @GetMapping("/ AlumniContribution")
	   public String showForm() {
	       return "AlumniContribution";
	   }

	   @PostMapping("/saveAlumni")
	   public String submitForm(
	       @RequestParam("Topic") String Topic,
	       @RequestParam("date") String date,                     
	       @RequestParam("resourceperson") String resourceperson,
	       @RequestParam("audience") String audience,
	       @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
	   {
	       System.out.println(date);
	       AlumniContributionSer.savelogic(Topic, date, resourceperson, audience, image1,image2); // ✅ Correct Service method call
	       return "redirect:/ AlumniContribution";
	   }
	   
	  
	@GetMapping("/ViewAlumniContribution")
    public String showFormData(Model model) {
        List<AlumniContributionEntity> formDataList = AlumniContributionSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "ViewAlumniContribution";
    }}
//	 @PostMapping("/alumni/delete/{id}")
//	    public String deleteEntry(@PathVariable int id) {
//		 AlumniContributionSer.deleteById(id);
//	        return "redirect:/CommunityView"; // Redirect to the display page
//	    }

	

