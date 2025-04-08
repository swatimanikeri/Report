package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.FacultyPaparEntity;

import com.project.repository.FacultyPaparRepo;

import jakarta.transaction.Transactional;

@Service
public class FacultyPaparSer {
	
	@Autowired
    private FacultyPaparRepo repo;

    @Transactional
    public void savelogic(String facultyname, String topic,String publicationdetails, MultipartFile image1, MultipartFile image2) throws IOException {
    	FacultyPaparEntity rep = new FacultyPaparEntity();
        rep.setFacultyname(facultyname);
        rep.setTopic(topic);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
      
        repo.save(rep);
    }

    public List<FacultyPaparEntity> getAllFormData() {
        return repo.findAll();  // ✅ Implement this!
    }
  
    public void deleteById(int sr_No) {
        repo.deleteById(sr_No); // Will throw EmptyResultDataAccessException if ID not found
    }

    
}
