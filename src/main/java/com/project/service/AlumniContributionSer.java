package com.project.service;

import java.io.IOException;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.AlumniContributionEntity;
import com.project.entity.CommunityServiceEntity;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.AlumniContributionRepo;

@Service

public class AlumniContributionSer {

    @Autowired
    private AlumniContributionRepo repo;

    public void savelogic(String topic, Date date, String resourceperson, String audience, String dynamicFieldsJson,MultipartFile image1 ,MultipartFile image2) throws IOException {
    	AlumniContributionEntity rep = new AlumniContributionEntity();
        rep.setTopic(topic);
        rep.setDate(date);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
        rep.setDynamicFieldsJson(dynamicFieldsJson);

        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }
    public List<AlumniContributionEntity> getAllFormData() {
        return repo.findAll();
    }
    public void deleteById(int srno) {
        if (repo.existsById(srno)) {
            repo.deleteById(srno);
        }
    }
	
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<AlumniContributionEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (AlumniContributionEntity project : allProjects) {
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
