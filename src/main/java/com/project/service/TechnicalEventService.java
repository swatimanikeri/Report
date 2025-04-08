package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.IndustrialVisitEntity;
import com.project.entity.TechnicalEventEntity;
import com.project.repository.IndustrialVisitRepo;
import com.project.repository.TechnicalEventRepo;

@Service
public class TechnicalEventService {

	 @Autowired
	    private TechnicalEventRepo repo;

	    // Method to save new Industrial Visit data
	    public void savelogic(String studentname, String event, String date, String organisedby,String status,MultipartFile image1,MultipartFile image2) throws IOException {
	        // Create an entity object and set the data
	        TechnicalEventEntity rep = new  TechnicalEventEntity();
	        rep.setStudentname(studentname);
	        rep.setEvent(event);
	        rep.setDate(date);
	        rep.setOrganisedby(organisedby);
	        rep.setStatus(status);
	        rep.setImage1(image1.getBytes());
	        rep.setImage2(image2.getBytes());
	        // Save the entity to the repository
	        repo.save(rep);
	    }

	    // Method to get all Industrial Visit data
	    public List<TechnicalEventEntity> getAllFormData() {
	        // Return the list of all Industrial Visit entities
	        return repo.findAll();
	    }
	    
	    public void deleteById(int id) {
	        if (repo.existsById(id)) {
	            repo.deleteById(id);
	        }
	    }
	}
