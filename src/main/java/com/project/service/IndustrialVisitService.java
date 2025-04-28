package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.IndustrialVisitEntity;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.IndustrialVisitRepo;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndustrialVisitService {

    @Autowired
    private IndustrialVisitRepo repo;

    // Method to save new Industrial Visit data
    public void savelogic(String industrynm, String date, String audience, String facultynm,String dynamicFieldsJson,MultipartFile imageData,MultipartFile image2) throws IOException {
        // Create an entity object and set the data
        IndustrialVisitEntity rep = new IndustrialVisitEntity();
        rep.setIndustrynm(industrynm);
        rep.setDate(date);
        rep.setAudience(audience);
        rep.setFacultynm(facultynm);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImageData(imageData.getBytes());
        rep.setImage2(image2.getBytes());
        // Save the entity to the repository
        repo.save(rep);
    }

    // Method to get all Industrial Visit data
    public List<IndustrialVisitEntity> getAllIndustryData() {
        // Return the list of all Industrial Visit entities
        return repo.findAll();
    }
    public void deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<IndustrialVisitEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (IndustrialVisitEntity project : allProjects) {
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
