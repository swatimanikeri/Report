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
import com.project.entity.SponsoredProjectEntity;
import com.project.entity.ValueaddEntity;
import com.project.repository.ValueaddRepo;




@Service
public class ValueaddSer
{

    @Autowired
    private  ValueaddRepo repo;

    public void savelogic(String Name, String Resourceperson,  String noofparticipants,String date, String dynamicFieldsJson, MultipartFile image1 ,MultipartFile image2) throws IOException {
        ValueaddEntity rep = new  ValueaddEntity();
        rep.setName(Name);
        rep.setResourceperson(Resourceperson);
        rep.setNoofparticipants(noofparticipants);
        
        rep.setDate(date);
        
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }

    public List<ValueaddEntity> getAllFormData() {
        return repo.findAll();  // ✅ Implement this!
    }
    public void deleteById(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<ValueaddEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (ValueaddEntity project : allProjects) {
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
