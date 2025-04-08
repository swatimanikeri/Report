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

import com.project.entity.SponsoredProjectEntity;
import com.project.service.SponsoredProjectSer;

@Controller
public class SponsoredProjectCont {
	@Autowired
    private  SponsoredProjectSer SponsoredProjectSer ;

    // Display the form
	@GetMapping("/SponsoredProject")
    public String SponPage(Authentication authspon) {
        return "SponsoredProject";
    }
    // Handle form submission (text + image)
    @PostMapping("/saveSpon")
    public String submitForm(@RequestParam("rollno") Integer rollno,
				            @RequestParam("studentname") String studentname,
				            @RequestParam("guide") String guide,
				            @RequestParam("projectnm") String projectnm,
				            @RequestParam("companydetails") String companydetails,
				            
				            @RequestParam("image1") MultipartFile image1,
				            @RequestParam("image2") MultipartFile image2) throws IOException 
    
      {
				System.out.println(studentname);
				SponsoredProjectSer.savelogic( rollno,studentname,guide,projectnm,companydetails,image1,image2);
				return "redirect:/SponsoredProject";
				}
                             

    // Display all form data along with images
    @GetMapping("/ViewSponsored")
    public String showFormData(Model model) {
        List<SponsoredProjectEntity> formDataList = SponsoredProjectSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "/ViewSponsored";
    }
    @PostMapping("/sponsored/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
    	SponsoredProjectSer.deleteById(id);
        return "redirect:/ViewSponsored"; // Redirect to the display page
    }

}
