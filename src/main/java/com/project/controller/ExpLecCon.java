package com.project.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.ExpLecEntity;
import com.project.service.ExpLecService;
@Controller
public class ExpLecCon{ 
   
   @Autowired 
   private ExpLecService  ExpLecService ;

   @GetMapping("/ExpLec")
   public String showForm() {
       return "/ExpLec";
   }

   @PostMapping("/saveExp")
   public String submitForm(
	   
       @RequestParam("TopicName") String TopicName,
       @RequestParam("DateConducted") String DateConducted,                     
       @RequestParam("resourceperson") String resourceperson,
       @RequestParam("audience") String audience,
       @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
   {
       System.out.println(DateConducted);
       ExpLecService.savelogic( TopicName, DateConducted, resourceperson, audience, image1, image2);
       return "redirect:/ExpLec";
   }
   
   @GetMapping("/ExpLecViewdata")
   public String showFormData(Model model) {
       // Fetch all data from the database
       List<ExpLecEntity> formDataList = ExpLecService.getAllFormData();
       model.addAttribute("formDataList", formDataList);
       return "ExpLecViewdata";  // Return the page to display form data
   }
  

}