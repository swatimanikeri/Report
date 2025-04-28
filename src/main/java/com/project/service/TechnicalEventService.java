package com.project.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.IndustrialVisitEntity;
import com.project.entity.SponsoredProjectEntity;
import com.project.entity.TechnicalEventEntity;
import com.project.repository.IndustrialVisitRepo;
import com.project.repository.TechnicalEventRepo;

@Service
public class TechnicalEventService {

	 @Autowired
	    private TechnicalEventRepo repo;

	    // Method to save new Industrial Visit data
	    public void savelogic(String studentname, String event, String date, String organisedby,String status,String dynamicFieldsJson,MultipartFile image1,MultipartFile image2) throws IOException {
	        // Create an entity object and set the data
	        TechnicalEventEntity rep = new  TechnicalEventEntity();
	
	        rep.setStudentname(studentname);
	        rep.setDate(date);
	        rep.setOrganisedby(organisedby);
	        rep.setStatus(status);
	        rep.setDynamicFieldsJson(dynamicFieldsJson);

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
	    public  Map<String, String> loadDynamicFieldNamesOnly() {
	        List<TechnicalEventEntity> allProjects = repo.findAll();
	        Map<String, String> fieldNames = new LinkedHashMap<>();
	        ObjectMapper objectMapper = new ObjectMapper();

	        for (TechnicalEventEntity project : allProjects) {
	            String json = project.getDynamicFieldsJson();
	            if (json != null && !json.isEmpty()) {
	                try {
	                    Map<String, String> dynamicFields = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});
	                    for (String key : dynamicFields.keySet()) {
	                        fieldNames.putIfAbsent(key, "");
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace(); // Log error if JSON is invalid
	                }
	            }
	        }

	        return fieldNames;
	    }
	}

	
