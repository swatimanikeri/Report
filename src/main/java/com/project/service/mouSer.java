package com.project.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.project.entity.Mou;
import com.project.repository.mouRepo;
import jakarta.transaction.Transactional;

@Service
public class mouSer {
    @Autowired
    private mouRepo repo;

    @Transactional
    public void savelogic(String orgnm, String activitydetails, MultipartFile image1, MultipartFile image2, String dynamicFieldsJson) throws IOException {
        Mou rep = new Mou();
        rep.setOrgnm(orgnm);
        rep.setActivitydetails(activitydetails);
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        rep.setDynamicFieldsJson(dynamicFieldsJson);
        repo.save(rep);
    }

    public List<Mou> getAllFormData() {
        return repo.findAll();
    }
    public void deleteById(int sr_No) {
        if (repo.existsById(sr_No)) {
            repo.deleteById(sr_No);
        }
    }
    
}
