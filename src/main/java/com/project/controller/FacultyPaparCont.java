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

import com.project.entity.FacultyPaparEntity;

import com.project.service.FacultyPaparSer;


@Controller
public class FacultyPaparCont {

	@Autowired
    private FacultyPaparSer FacultyPaparSer ;

    @GetMapping("/FacultyPapar")
    public String showSponsoredForm(Model model) {
	    Map<String, String> dynamicFields = FacultyPaparSer.loadDynamicFieldNamesOnly(); // use your bean here
	    model.addAttribute("dynamicJson", dynamicFields);
        return "FacultyPapar";
    }

    // Handle form submission (text + image) if we are entering data from html page then controller come to here and here we are saving it to table
    @PostMapping("/saveFaculty")
    public String submitForm(
                              @RequestParam("facultyname") String facultyname,
                              @RequestParam("topic") String topic,                     
                              @RequestParam("publicationdetails") String publicationdetails,
                              @RequestParam("dynamicFields") String dynamicFieldsJson,
                             @RequestParam("image1") MultipartFile image1,
                              @RequestParam("image2") MultipartFile image2)throws IOException
    {
        System.out.println(topic);
        FacultyPaparSer.savelogic(facultyname, topic, publicationdetails, dynamicFieldsJson,image1,image2);
        return "redirect:/FacultyPapar";
    }
                             @GetMapping("/ViewFacultyPapar")
                             public String showIndustryData(Model model) {
                                 List<FacultyPaparEntity> formDataList = FacultyPaparSer.getAllFormData();
                                 model.addAttribute("formDataList", formDataList);
                                 return "ViewFacultyPapar";
                             
                             }
                             @PostMapping("/faculty/delete/{sr_No}")
                             public String deleteEntry(@PathVariable int sr_No) {
                            	 FacultyPaparSer.deleteById(sr_No);
                                 return "redirect:/ViewIFacultyPapar"; // Redirect to the display page
                             }
	
	
	
	
	
	
}


