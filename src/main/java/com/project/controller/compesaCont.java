package com.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.CompesaCsi;
import com.project.service.*;



@Controller
public class compesaCont {
	@Autowired
    private compesaSer compesaSer;

    // Display the form
	@GetMapping("/compesaCsi")
	public String showSponsoredForm(Model model) {
	    Map<String, String> dynamicFields = compesaSer.loadDynamicFieldNamesOnly(); // use your bean here
	    model.addAttribute("dynamicJson", dynamicFields);
        return "compesaCsi";
    }

    // Handle form submission (text + image)
    @PostMapping("/saveComp")
    public String submitForm(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
				            @RequestParam("activities") String activities,
				            @RequestParam("dynamicFields") String dynamicFieldsJson,
				            @RequestParam("image1") MultipartFile image1,
    @RequestParam("image2") MultipartFile image2)throws IOException {
				System.out.println(date);
				compesaSer.savelogic( date,activities,dynamicFieldsJson,image1,image2);
				return "redirect:/compesaCsi";
				}
                             

    // Display all form data along with images
    @GetMapping("/viewCompesa")
    public String showFormData(Model model) {
        List<CompesaCsi> formDataList = compesaSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "viewCompesa";
    }
    @PostMapping("/compesa/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
    	compesaSer.deleteById(id);
        return "redirect:/viewCompesa"; // Redirect to the display page
    }

}