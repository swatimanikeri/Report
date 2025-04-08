package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.CompesaCsi;
import com.project.repository.compesaRepo;

import jakarta.transaction.Transactional;

@Service
public class compesaSer {
    @Autowired
    private compesaRepo repo;
 @Transactional
    public void savelogic( String dates, String activities,MultipartFile image1,MultipartFile image2) throws IOException {
        // Create a new entity object to store the data
        CompesaCsi rep = new CompesaCsi();
//        rep.setSr_No(sr_No);
        rep.setDates(dates);
        rep.setActivities(activities);
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
}
