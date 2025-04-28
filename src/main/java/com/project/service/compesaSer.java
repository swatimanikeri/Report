package com.project.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.CompesaCsi;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.compesaRepo;

import jakarta.transaction.Transactional;

@Service
public class compesaSer {
    @Autowired
    private compesaRepo repo;
 @Transactional
    public void savelogic( Date date, String activities,String dynamicFieldsJson,MultipartFile image1,MultipartFile image2) throws IOException {
        // Create a new entity object to store the data
        CompesaCsi rep = new CompesaCsi();
//        rep.setSr_No(sr_No);
        rep.setDate(date);
        rep.setActivities(activities);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        // Save the entity to the database
        repo.save(rep);  // Assuming compesaRepo is a Spring Data JPA repository
    }
 public List<CompesaCsi> getAllFormData() {
     return repo.findAll();
 }
 public void deleteById(int id) {
     if (repo.existsById(id)) {
         repo.deleteById(id);
     }
 }
 public Map<String, String> loadDynamicFieldNamesOnly() {
     List<CompesaCsi> allProjects = repo.findAll();
     Map<String, String> fieldNames = new LinkedHashMap<>();
     ObjectMapper objectMapper = new ObjectMapper();

     for (CompesaCsi project : allProjects) {
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

