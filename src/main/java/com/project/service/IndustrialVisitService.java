package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.IndustrialVisitEntity;
import com.project.repository.IndustrialVisitRepo;

import java.io.IOException;
import java.util.List;

@Service
public class IndustrialVisitService {

    @Autowired
    private IndustrialVisitRepo repo;

    // Method to save new Industrial Visit data
    public void savelogic(String industrynm, String date, String audience, String facultynm,MultipartFile imageData,MultipartFile image2) throws IOException {
        // Create an entity object and set the data
        IndustrialVisitEntity rep = new IndustrialVisitEntity();
        rep.setIndustrynm(industrynm);
        rep.setDate(date);
        rep.setAudience(audience);
        rep.setFacultynm(facultynm);
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
}
