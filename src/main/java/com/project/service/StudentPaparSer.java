package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.project.entity.PaperbyStudents;

import com.project.repository.StudentPaparRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentPaparSer {
	@Autowired
    private StudentPaparRepo repo;
	
    @Transactional
    public void savelogic(int groupno, int rollno,String studentname,String topic,String paperdetails, MultipartFile image1, MultipartFile image2) throws IOException {
    	PaperbyStudents rep = new PaperbyStudents();
        rep.setGroupno(groupno);
        rep.setRollno(rollno);
        rep.setStudentname(studentname);
        rep.setTopic(topic);
        rep.setPaperdetails(paperdetails);
        
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
      
        repo.save(rep);
    }

    public List<PaperbyStudents> getAllFormData() {
        return repo.findAll();  // ✅ Implement this!
    }
  
    public void deleteById(int sr_No) {
        repo.deleteById(sr_No); // Will throw EmptyResultDataAccessException if ID not found
    }

    
}
