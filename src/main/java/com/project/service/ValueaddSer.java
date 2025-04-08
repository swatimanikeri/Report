package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.ValueaddEntity;
import com.project.repository.ValueaddRepo;




@Service
public class ValueaddSer
{

    @Autowired
    private  ValueaddRepo repo;

    public void savelogic(String Name, String Resourceperson,  String noofparticipants,String date, MultipartFile image1 ,MultipartFile image2) throws IOException {
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
  
}