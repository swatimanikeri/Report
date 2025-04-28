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
import com.project.entity.ExpLecEntity;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.ExpLecRepo;




@Service
public class ExpLecService 
{

    @Autowired
    private ExpLecRepo repo;

    public void savelogic(String topicname, Date date, String resourceperson, String audience, String dynamicFieldsJson,MultipartFile image1 ,MultipartFile image2) throws IOException {
    	ExpLecEntity rep = new ExpLecEntity();
    
        rep.setTopicname(topicname);
        rep.setDate(date);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }
    public List<ExpLecEntity> getAllFormData() {
        return repo.findAll();
    }

    public void deleteById(int srno) {
        if (repo.existsById(srno)) {
            repo.deleteById(srno);
        }
    }
    
 // ✅ New method to extract unique dynamic field names
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<ExpLecEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (ExpLecEntity project : allProjects) {
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
