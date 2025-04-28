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

import com.project.entity.WorkshopOrganized;
import com.project.service.WorkshopOrganizedSer;

@Controller

public class WorkshopOrganizedCont {

    @Autowired
    private WorkshopOrganizedSer workshopOrganizedSer;

    @GetMapping("/WorkshopOrganized")
    public String showSponsoredForm(Model model) {
    	Map<String, String> dynamicFields = workshopOrganizedSer.loadDynamicFieldNamesOnly();

	    model.addAttribute("dynamicJson", dynamicFields);
        return "WorkshopOrganized";
    }

    @PostMapping("/savework")
    public String submitForm(
            @RequestParam("name_of_Workshop") String name_of_Workshop,
            @RequestParam("no_of_participents") Integer no_of_participents,
            @RequestParam("date_conducted") String date_conducted,
            @RequestParam("dynamicFields") String dynamicFieldsJson,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("image2") MultipartFile image2) throws IOException {

        workshopOrganizedSer.savelogic(name_of_Workshop, no_of_participents, date_conducted, dynamicFieldsJson,image1, image2);
        return "redirect:/WorkshopOrganized";
    }

    @GetMapping("/ViewWorkshopOrganized")
    public String showFormData(Model model) {
        List<WorkshopOrganized> formDataList = workshopOrganizedSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "ViewWorkshopOrganized";
    }

    @PostMapping("/workshop/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
        workshopOrganizedSer.deleteById(id);
        return "redirect:/ViewWorkshopOrganized";
    }
}
