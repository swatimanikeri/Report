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

import com.project.entity.ValueaddEntity;
import  com.project.service.ValueaddSer;


@Controller
public class ValueaddCon{ 
    
    @Autowired 
    private ValueaddSer ValueaddSer;

    @GetMapping("/Valueadd")
    public String showForm() {
        return "/Valueadd";
    }

    @PostMapping("/savevalue")
    public String submitForm(
        @RequestParam("Name") String Name,
        @RequestParam("Resourceperson") String Resourceperson,
        @RequestParam("noofparticipants") String noofparticipants,
        @RequestParam("date") String date,                     
        
        @RequestParam("image1") MultipartFile image1,@RequestParam("image2") MultipartFile image2) throws IOException 
    {
        System.out.println(date);
        ValueaddSer.savelogic(Name,Resourceperson,noofparticipants, date,image1,image2); // ✅ Correct Service method call
        return "redirect:/Valueadd";
    }
    
    @GetMapping("/ValueaddViwedata")
    public String showFormData(Model model) {
        // Fetch all data from the database
        List<ValueaddEntity> formDataList = ValueaddSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "ValueaddViwedata";  // Return the page to display form data
    }}
