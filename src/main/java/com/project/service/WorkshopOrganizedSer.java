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
import com.project.entity.WorkshopOrganized;
import com.project.repository.WorkshopOrganizedRepo;

@Service
public class WorkshopOrganizedSer {

    @Autowired
    private WorkshopOrganizedRepo repo;

    public void savelogic(String name_of_Workshop, Integer no_of_participents, String date_conducted,
    		String dynamicFieldsJson,MultipartFile image1, MultipartFile image2) throws IOException {
        WorkshopOrganized rep = new WorkshopOrganized();
        rep.setName_of_Workshop(name_of_Workshop);
        rep.setNo_of_participents(no_of_participents);
        rep.setDate_conducted(date_conducted);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        repo.save(rep);
    }

    public List<WorkshopOrganized> getAllFormData() {
        return repo.findAll();
    }

    public void deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<WorkshopOrganized> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (WorkshopOrganized project : allProjects) {
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

