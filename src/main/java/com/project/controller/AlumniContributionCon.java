package com.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.AlumniContributionEntity;

import com.project.service.AlumniContributionSer;

@Controller
public class AlumniContributionCon {

	
	@Autowired 
	   private AlumniContributionSer  AlumniContributionSer;

	   @GetMapping("/AlumniContribution")
	   public String showSponsoredForm(Model model) {
	   Map<String, String> dynamicFields = AlumniContributionSer.loadDynamicFieldNamesOnly(); 
	    model.addAttribute("dynamicJson", dynamicFields);
	       return "AlumniContribution";
	   }

	   @PostMapping("/saveAlumni")
	   public String submitForm(
	       @RequestParam("topic") String topic,
	       @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,                     
	       @RequestParam("resourceperson") String resourceperson,
	       @RequestParam("audience") String audience,
	       @RequestParam("dynamicFields") String dynamicFieldsJson,
	       @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
	   {
	       System.out.println(date);
	       AlumniContributionSer.savelogic(topic, date, resourceperson, audience, dynamicFieldsJson,image1,image2); 
	       return "redirect:/AlumniContribution";
	   }
	   
	  
	@GetMapping("/ViewAlumniContribution")
    public String showFormData(Model model) {
        List<AlumniContributionEntity> formDataList = AlumniContributionSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "ViewAlumniContribution";
    }
	 @PostMapping("/alumni/delete/{srno}")
	    public String deleteEntry(@PathVariable int srno) {
		 AlumniContributionSer.deleteById(srno);
	        return "redirect:/ViewAlumniContribution"; 
	    }
	}

	

