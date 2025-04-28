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

import com.project.entity.CompesaCsi;
import com.project.entity.IndustrialVisitEntity;
import com.project.service.IndustrialVisitService;

@Controller
public class IndustrialVisitCont {

    @Autowired
    private IndustrialVisitService industrialVisitService;

    @GetMapping("/IndustrialVisit")
    public String showSponsoredForm(Model model) {
	    Map<String, String> dynamicFields = industrialVisitService.loadDynamicFieldNamesOnly(); // use your bean here
	    model.addAttribute("dynamicJson", dynamicFields);
        return "IndustrialVisit";
    }

    // Handle form submission (text + image) if we are entering data from html page then controller come to here and here we are saving it to table
    @PostMapping("/saveInd")
    public String submitForm(
                              @RequestParam("industrynm") String industrynm,
                              @RequestParam("date") String date,                     
                              @RequestParam("audience") String audience,
                              @RequestParam("facultynm") String facultynm,
                              @RequestParam("dynamicFields") String dynamicFieldsJson,
                              @RequestParam("imageData") MultipartFile imageData,
                              @RequestParam("image2") MultipartFile image2)throws IOException
    {
        System.out.println(date);
        industrialVisitService.savelogic(industrynm, date, audience, facultynm,dynamicFieldsJson,imageData,image2);
        return "redirect:/IndustrialVisit";
    }
                             @GetMapping("/ViewIndustrialVisit")
                             public String showIndustryData(Model model) {
                                 List<IndustrialVisitEntity> formDataList = industrialVisitService.getAllIndustryData();
                                 model.addAttribute("formDataList", formDataList);
                                 return "ViewIndustrialVisit";
                             
                             }
                             @PostMapping("/industrial/delete/{id}")
                             public String deleteEntry(@PathVariable int id) {
                            	 industrialVisitService.deleteById(id);
                                 return "redirect:/ViewIndustrialVisit"; // Redirect to the display page
                             }
}
