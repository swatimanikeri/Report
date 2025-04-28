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
import com.project.entity.PaperbyStudents;
import com.project.entity.SponsoredProjectEntity;
import com.project.repository.StudentPaparRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentPaparSer {
	@Autowired
    private StudentPaparRepo repo;
	
    @Transactional
    public void savelogic(int groupno, int rollno,String studentname,String topic,String paperdetails, String dynamicFieldsJson,MultipartFile image1, MultipartFile image2) throws IOException {
    	PaperbyStudents rep = new PaperbyStudents();
        rep.setGroupno(groupno);
        rep.setRollno(rollno);
        rep.setStudentname(studentname);
        rep.setTopic(topic);
        rep.setPaperdetails(paperdetails);
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
      
        repo.save(rep);
    }

    public List<PaperbyStudents> getAllFormData() {
        return repo.findAll();  // ✅ Implement this!
    }
  
    public void deleteById(int sr_No) {
        repo.deleteById(sr_No); // Will throw EmptyResultDataAccessException if ID not found
    }

    public Map<String, String> loadDynamicFieldNamesOnly() {
        List<PaperbyStudents> allProjects = repo.findAll();
        Map<String, String> fieldNames = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (PaperbyStudents project : allProjects) {
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
