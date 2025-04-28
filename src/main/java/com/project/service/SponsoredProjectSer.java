package com.project.service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.SponsoredProjectRepo;

@Service
public class SponsoredProjectSer {

    @Autowired
    private SponsoredProjectRepo repo;

    public void savelogic(Integer rollno, String studentname, String guide, String projectnm, String companydetails, String dynamicFieldsJson, MultipartFile image1, MultipartFile image2) throws IOException {
        System.out.println("Saving Dynamic Fields JSON: " + dynamicFieldsJson);  // Debugging line

        SponsoredProjectEntity rep = new SponsoredProjectEntity();
        rep.setRollno(rollno);
        rep.setStudentname(studentname);
        rep.setGuide(guide);
        rep.setProjectnm(projectnm);
        rep.setCompanydetails(companydetails);
        rep.setDynamicFieldsJson(dynamicFieldsJson);

        // Convert MultipartFile to byte[] and set it in the entity
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());

        // Save the entity in the repository
        repo.save(rep);
    }

    public List<SponsoredProjectEntity> getAllFormData() {
        return repo.findAll();
    }

    public void deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }

    // ✅ New method to extract unique dynamic field names
    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<SponsoredProjectEntity> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (SponsoredProjectEntity project : allProjects) {
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
