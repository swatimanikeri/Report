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

import com.project.entity.PaperbyStudents;
import com.project.service.StudentPaparSer;

@Controller
public class StudentPaparCont {

    
@Autowired                                                                                                                   
private StudentPaparSer StudentPaparSer ;                                                                                    
    
@GetMapping("/StudentPapar")                                                                                                 
public String IndPage(Authentication authind) {                                                                              
return "StudentPapar";                                                                                                   
}                                                                                                                            
    
// Handle form submission (text + image) if we are entering data from html page then controller come to here and here we are 
@PostMapping("/saveStudent")                                                                                            
public String submitForm(                                                                                                    
@RequestParam("groupno") int groupno,                                                   
@RequestParam("rollno") int rollno,                                                               
@RequestParam("studentname") String studentname,  
@RequestParam("topic") String topic,  
@RequestParam("paperdetails") String paperdetails,  

@RequestParam("image1") MultipartFile image1,                                                       
@RequestParam("image2") MultipartFile image2)throws IOException                                    
{                                                                                                                            
System.out.println(topic);                                                                                               
StudentPaparSer.savelogic(groupno, rollno, studentname,topic,paperdetails, image1,image2);                                        
return "redirect:/StudentPapar";                                                                                         
}                                                                                                                            
@GetMapping("/ViewStudentPapar")                                                                    
public String showIndustryData(Model model) {                                                       
	List<PaperbyStudents> formDataList = StudentPaparSer.getAllFormData();                       
model.addAttribute("formDataList", formDataList);                                               
return "ViewStudentPapar";                                                                      
    
}                                                                                                   
@PostMapping("/studentpapar/delete/{sr_no}")                                                        
public String deleteEntry(@PathVariable int sr_no) {                                                
StudentPaparSer.deleteById(sr_no);                                                              
return "redirect:/ViewStudentPapar"; // Redirect to the display page                           
}                                                                                                   
}
  
  
  
  
  
    
    
    
    
	
	
	

