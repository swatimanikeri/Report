package com.project.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.ExpLecEntity;
import com.project.repository.ExpLecRepo;




@Service
public class ExpLecService 
{

    @Autowired
    private ExpLecRepo repo;

    public void savelogic(String TopicName, String DateConducted, String resourceperson, String audience, MultipartFile image1 ,MultipartFile image2) throws IOException {
    	ExpLecEntity rep = new ExpLecEntity();
    
        rep.setTopicName(TopicName);
        rep.setDateConducted(DateConducted);
        rep.setResourceperson(resourceperson);
        rep.setAudience(audience);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        repo.save(rep); // ✅ Now it will work perfectly!
    }
    public List<ExpLecEntity> getAllFormData() {
        return repo.findAll();
    }
  
}