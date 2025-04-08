package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.CommunityServiceEntity;

import com.project.repository.CommunityServicesRepo;

@Service
public class CommunityServicesSer {

    @Autowired
    private CommunityServicesRepo repo;

    public void savelogic(String activity, String date, String resourceperson, String audience, MultipartFile image1 ,MultipartFile image2) throws IOException {
        CommunityServiceEntity rep = new CommunityServiceEntity();
        rep.setActivity(activity);
        rep.setDate(date);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
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
}
