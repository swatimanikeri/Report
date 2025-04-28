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
import com.project.entity.CommunityServiceEntity;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.CommunityServicesRepo;

@Service
public class CommunityServicesSer {

    @Autowired
    private CommunityServicesRepo repo;

    public void savelogic(String activity, String date, String resourceperson, String audience, String dynamicFieldsJson,MultipartFile image1 ,MultipartFile image2) throws IOException {
        CommunityServiceEntity rep = new CommunityServiceEntity();
        rep.setActivity(activity);
        rep.setDate(date);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }
    public List<CommunityServiceEntity> getAllFormData() {
        return repo.findAll();
    }
    public void deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<CommunityServiceEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (CommunityServiceEntity project : allProjects) {
            String json = project.getDynamicFieldsJson();
            if (json != null && !json.isEmpty()) {
                try {
                    Map<String, String> dynamicFields = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});
                    for (String key : dynamicFields.keySet()) {
                        fieldNames.putIfAbsent(key, "");
                    }
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        }

        return fieldNames;
    }
}
