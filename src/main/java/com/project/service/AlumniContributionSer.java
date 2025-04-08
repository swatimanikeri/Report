package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.AlumniContributionEntity;
import com.project.entity.CommunityServiceEntity;
import com.project.repository.AlumniContributionRepo;

@Service

public class AlumniContributionSer {

    @Autowired
    private AlumniContributionRepo repo;

    public void savelogic(String Topic, String date, String resourceperson, String audience, MultipartFile image1 ,MultipartFile image2) throws IOException {
    	AlumniContributionEntity rep = new AlumniContributionEntity();
        rep.setActivity(Topic);
        rep.setDate(date);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }
    public List<AlumniContributionEntity> getAllFormData() {
        return repo.findAll();
    }
	

	
	
}
