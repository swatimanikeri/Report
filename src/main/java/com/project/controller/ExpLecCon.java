package com.project.controller;
import org.springframework.security.core.Authentication;


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

import com.project.entity.ExpLecEntity;
import com.project.service.ExpLecService;
@Controller
public class ExpLecCon{ 
   
   @Autowired 
   private ExpLecService  ExpLecService ;

   @GetMapping("/ExpLec")
	public String showSponsoredForm(Authentication authentication,Model model) {
	   String username = authentication.getName();  
	    model.addAttribute("username", username);
	    Map<String, String> dynamicFields = ExpLecService.loadDynamicFieldNamesOnly(); // use your bean here
	    model.addAttribute("dynamicJson", dynamicFields);
       return "/ExpLec";
   }

   @PostMapping("/saveExp")
   public String submitForm(
	   
       @RequestParam("topicname") String topicname,
       @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date  date,                     
       @RequestParam("resourceperson") String resourceperson,
       @RequestParam("audience") String audience,
       @RequestParam("dynamicFields") String dynamicFieldsJson,
       @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
   {
       System.out.println(date);
       ExpLecService.savelogic( topicname, date, resourceperson, audience,dynamicFieldsJson, image1, image2);
       return "redirect:/ExpLec";
   }
   
   @GetMapping("/ExpLecViewdata")
   public String showFormData(Model model) {
       // Fetch all data from the database
       List<ExpLecEntity> formDataList = ExpLecService.getAllFormData();
       model.addAttribute("formDataList", formDataList);
       return "ExpLecViewdata";  // Return the page to display form data
   }
   @PostMapping("/expert/delete/{srno}")
   public String deleteEntry(@PathVariable int id) {
	   ExpLecService .deleteById(id);
       return "redirect:/ExpLecViewdata"; // Redirect to the display page
   }
  

}